package org.example.myoutlook.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.myoutlook.data.Repo.AuthRepositoryImpl
import org.example.myoutlook.data.remoteDataSourse.MailTmApiImpl
import org.example.myoutlook.domain.repo.AuthRepo
import org.example.myoutlook.domain.useCases.LoginUserUseCase
import org.example.myoutlook.domain.useCases.RegisterUserUseCase
import kotlin.reflect.KClass

class AuthViewModelFactory : ViewModelProvider.Factory {

    private val httpClient by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                })
            }

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

    private val mailTmApi by lazy { MailTmApiImpl(httpClient) }
    private val authRepository: AuthRepo by lazy { AuthRepositoryImpl(mailTmApi) }
    private val loginUseCase by lazy { LoginUserUseCase(authRepository) }
    private val registerUseCase by lazy { RegisterUserUseCase(authRepository) }

     fun <T : ViewModel> create(modelClass: KClass<T>): T {
        return when (modelClass) {
            AuthViewModel::class -> AuthViewModel(loginUseCase, registerUseCase) as T
            else -> error("Unknown ViewModel class: ${modelClass.simpleName}")
        }
    }
}