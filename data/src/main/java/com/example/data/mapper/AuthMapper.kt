package com.example.data.mapper

import com.example.domain.model.AuthResponse
import com.example.domain.model.LoginRequest
import com.example.domain.model.SignUpRequest
import com.example.domain.model.User
import com.example.network.dto.AuthResponseDto
import com.example.network.dto.LoginRequestDto
import com.example.network.dto.SignUpRequestDto
import com.example.network.dto.UserDto

fun LoginRequest.toLoginRequestDto(): LoginRequestDto{
    return LoginRequestDto(
        email = this.email,
        password = this.password
    )
}

fun AuthResponseDto.toAuthResponse(): AuthResponse {
    return AuthResponse(
        accessToken = this.accessToken,
        accessTokenExpiresAt = this.accessTokenExpiresAt,
        refreshToken = this.refreshToken,
        refreshTokenExpiresAt = this.refreshTokenExpiresAt,
        user = this.user.toUser()
    )
}

fun UserDto.toUser(): User{
    return User(
        id = this.id,
        name = this.name,
        avatarUrl = this.avatarUrl,
        email = this.email
    )
}

fun SignUpRequest.toSignUpRequestDto(): SignUpRequestDto {
    return SignUpRequestDto(
        email = this.email,
        password = this.password,
        name = this.name
    )
}
