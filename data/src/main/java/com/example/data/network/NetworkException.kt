package com.example.data.network

sealed class NetworkException(
    cause: Throwable? = null
) : Exception(cause) {

    class NoInternet(
        cause: Throwable? = null
    ) : NetworkException(cause)

    class Timeout(
        cause: Throwable? = null
    ) : NetworkException(cause)

    class Unauthorized : NetworkException()

    class Forbidden : NetworkException()

    class NotFound : NetworkException()

    class ServerError : NetworkException()

    class EmptyResponse : NetworkException()

    class Unknown(
        cause: Throwable? = null
    ) : NetworkException(cause)
}