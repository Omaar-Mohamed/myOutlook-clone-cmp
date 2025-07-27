package org.example.myoutlook.presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.myoutlook.domain.useCases.LoginUserUseCase
import org.example.myoutlook.domain.useCases.RegisterUserUseCase

class AuthViewModel(
    private val loginUserUseCase: LoginUserUseCase,
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf("")

    fun onLogin() {
        viewModelScope.launch {
            try {
                val user = loginUserUseCase(email, password)
                message = "Welcome ${'$'}{user.email}"
            } catch (e: Exception) {
                println("Login error: ${e.message}")
                message = "Login failed "
                
            }
        }
    }

    fun onRegister() {
        viewModelScope.launch {
            try {
                val user = registerUserUseCase(email, password)
                message = "Registered ${'$'}{user.email}"
            } catch (e: Exception) {
                message = "Registration failed"
            }
        }
    }
}
