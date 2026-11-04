package com.example.domain.model

data class AuthResponse(
    val accessToken: String,
    val accessTokenExpiresAt: String,
    val refreshToken: String,
    val refreshTokenExpiresAt: String,
    val user: User

)

data class User(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    val email: String
)
