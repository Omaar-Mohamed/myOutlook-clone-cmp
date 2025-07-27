package org.example.myoutlook.data.Repo

import org.example.myoutlook.data.remoteDataSourse.MailTmApi
import org.example.myoutlook.domain.model.User
import org.example.myoutlook.domain.repo.AuthRepo

class AuthRepositoryImpl(private val api: MailTmApi) : AuthRepo {
    override suspend fun register(email: String, password: String): User {
        api.register(email, password)
        val token = api.login(email, password)
        return User(id = email, email = email, token = token)
    }

    override suspend fun login(email: String, password: String): User {
        val token = api.login(email, password)
        return User(id = email, email = email, token = token)
    }
}