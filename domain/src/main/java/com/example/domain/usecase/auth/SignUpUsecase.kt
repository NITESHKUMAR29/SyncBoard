package com.example.domain.usecase.auth


import com.example.domain.error.AppError
import com.example.domain.model.AuthResponse
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUsecase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(name: String, email: String, password: String): Result<AuthResponse> {
        if (email.isBlank() || password.isBlank()|| name.isBlank()) {
            return Result.failure(AppError.EmptyFields())
        }


        if (password.length < 8) {
            return Result.failure(AppError.InvalidPassword())
        }
        return repository.register(name, email,password)
    }
}