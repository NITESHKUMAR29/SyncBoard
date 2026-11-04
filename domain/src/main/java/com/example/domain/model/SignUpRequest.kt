package com.example.domain.model

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String
)
