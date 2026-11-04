package com.example.data.repository

import android.util.Log
import com.example.data.mapper.toAuthResponse
import com.example.data.mapper.toLoginRequestDto
import com.example.data.mapper.toSignUpRequestDto
import com.example.data.network.ApiErrorHandler
import com.example.data.network.NetworkException
import com.example.domain.error.AppError
import com.example.domain.model.AuthResponse
import com.example.domain.model.LoginRequest
import com.example.domain.model.SignUpRequest
import com.example.domain.repository.AuthRepository
import com.example.network.apiInterface.SyncBoardApi

import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(val api: SyncBoardApi) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthResponse> {

        val loginRequest = LoginRequest(
            email = email,
            password = password
        )

        return try {

            val response = api.login(
                loginRequest.toLoginRequestDto()
            )

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {

                    Result.success(
                        body.toAuthResponse()
                    )

                } else {

                    Result.failure(
                        AppError.Unknown()
                    )
                }

            } else {

                val networkException =
                    ApiErrorHandler.handleResponse(response)

                Result.failure(
                    networkException.toAppError()
                )
            }

        } catch (e: Exception) {

            val networkException =
                ApiErrorHandler.handleException(e)

            Result.failure(
                networkException.toAppError()
            )
        }
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): Result<AuthResponse> {
        val signUpRequest = SignUpRequest(
            name = name,
            email = email,
            password = password
        )

        return try {
            val response = api.register(signUpRequest.toSignUpRequestDto())
            Log.d("AuthRepositoryImpl", "register: ${response.body()}")

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Result.success(body.toAuthResponse())
                } else {
                    Result.failure(AppError.Unknown())
                }
            } else {
                val networkException = ApiErrorHandler.handleResponse(response)
                Result.failure(networkException.toAppError())
            }
        } catch (e: Exception) {
            val networkException =
                ApiErrorHandler.handleException(e)

            Result.failure(
                networkException.toAppError()
            )
        }

    }
}

private fun NetworkException.toAppError(): AppError {

    return when (this) {

        is NetworkException.NoInternet ->
            AppError.NoInternet()

        is NetworkException.Timeout ->
            AppError.Timeout()

        is NetworkException.Unauthorized ->
            AppError.Unauthorized()

        is NetworkException.Forbidden ->
            AppError.Forbidden()

        is NetworkException.NotFound ->
            AppError.NotFound()

        is NetworkException.ServerError ->
            AppError.ServerError()

        is NetworkException.EmptyResponse ->
            AppError.Unknown()

        is NetworkException.Unknown ->
            AppError.Unknown()
    }
}