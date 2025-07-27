package org.example.myoutlook.domain.useCases

import org.example.myoutlook.domain.model.User
import org.example.myoutlook.domain.repo.AuthRepo

class LoginUserUseCase(private val repo: AuthRepo) {
    suspend operator fun invoke(email: String, password: String): User {
        return repo.login(email, password)
    }
}