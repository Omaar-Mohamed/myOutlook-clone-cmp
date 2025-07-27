package org.example.myoutlook.domain.repo

import org.example.myoutlook.domain.model.User

interface AuthRepo {
    suspend fun register(email: String, password: String): User
    suspend fun login(email: String, password: String): User

}