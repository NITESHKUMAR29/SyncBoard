package com.example.domain.usecase.auth


import com.example.domain.error.AppError
import com.example.domain.model.AuthResponse
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUsecase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<AuthResponse> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(AppError.EmptyFields())
        }


        if (password.length < 8) {
            return Result.failure(AppError.InvalidPassword())
        }
        return repository.login(email, password)
    }
}