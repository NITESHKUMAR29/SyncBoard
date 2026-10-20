package com.example.network.dto


data class AuthResponseDto(
    val accessToken: String,
    val accessTokenExpiresAt: String,
    val refreshToken: String,
    val refreshTokenExpiresAt: String,
    val user: UserDto
)


data class UserDto(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    val email: String
)