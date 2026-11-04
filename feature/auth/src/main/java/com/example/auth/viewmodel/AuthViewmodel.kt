package com.example.auth.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.uiState.AuthUiState
import com.example.data.network.NetworkException
import com.example.domain.error.AppError
import com.example.domain.usecase.auth.LoginUsecase
import com.example.domain.usecase.auth.SignUpUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewmodel @Inject constructor(
    private val loginUseCase: LoginUsecase,
    private val signUpUseCase: SignUpUsecase
) : ViewModel() {
    private val _login = MutableStateFlow(AuthUiState())
    val login = _login.asStateFlow()

    private val _signUp = MutableStateFlow(AuthUiState())
    val signUp = _signUp.asStateFlow()


    fun login(
        email: String,
        password: String
    ) {

        viewModelScope.launch {

            _login.value = AuthUiState(
                isLoading = true
            )

            val result = loginUseCase(
                email = email,
                password = password
            )

            result
                .onSuccess {

                    _login.value = AuthUiState(
                        isLoading = false,
                        isSuccessful = true,
                        data = it
                    )
                }

                .onFailure { error ->

                    val errorMessage =
                        getErrorMessage(error)

                    _login.value = AuthUiState(
                        isLoading = false,
                        error = errorMessage
                    )
                }
        }
    }

    fun signUp(name: String, email: String, password: String) {
        viewModelScope.launch {
            _signUp.value = AuthUiState(isLoading = true)

            val result = signUpUseCase(name, email, password)

            result.onSuccess {
                _signUp.value = AuthUiState(
                    isLoading = false,
                    data = it,
                    isSuccessful = true

                )
            }.onFailure { error ->
                val errorMessage =
                    getErrorMessage(error)

                _signUp.value = AuthUiState(
                    isLoading = false,
                    error = errorMessage
                )
            }


        }
    }


    private fun getErrorMessage(
        error: Throwable
    ): String {

        return when (error) {

            is AppError.EmptyFields ->
                "Email and password cannot be empty"

            is AppError.InvalidPassword ->
                "Password must be at least 8 characters"

            is AppError.NoInternet ->
                "Please check your internet connection"

            is AppError.Timeout ->
                "Request timed out. Please try again"

            is AppError.Unauthorized ->
                "Invalid email or password"

            is AppError.Forbidden ->
                "You don't have permission to perform this action"

            is AppError.NotFound ->
                "Requested resource was not found"

            is AppError.ServerError ->
                "Server error. Please try again later"

            else ->
                "Something went wrong"
        }
    }
}

