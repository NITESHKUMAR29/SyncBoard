package com.example.domain.repository

import com.example.domain.model.AuthResponse

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<AuthResponse>
    suspend fun register(name: String, email: String, password: String): Result<AuthResponse>
}