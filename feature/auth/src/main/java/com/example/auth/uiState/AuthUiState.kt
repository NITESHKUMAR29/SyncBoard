package com.example.auth.uiState

import com.example.domain.model.AuthResponse

data class AuthUiState(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val data: AuthResponse? = null,
    val error: String? = null,
)
