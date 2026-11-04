package com.example.data.network

import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

object ApiErrorHandler {

    fun handleException(e: Exception): NetworkException {
        return when (e) {

            is SocketTimeoutException ->
                NetworkException.Timeout(cause = e)

            is IOException ->
                NetworkException.NoInternet(cause = e)

            else ->
                NetworkException.Unknown(cause = e)
        }
    }

    fun handleResponse(response: Response<*>): NetworkException {

        return when (response.code()) {

            401 ->
                NetworkException.Unauthorized()

            403 ->
                NetworkException.Forbidden()

            404 ->
                NetworkException.NotFound()

            in 500..599 ->
                NetworkException.ServerError()

            else ->
                NetworkException.Unknown(
                    cause = Exception("HTTP ${response.code()}")
                )
        }
    }
}