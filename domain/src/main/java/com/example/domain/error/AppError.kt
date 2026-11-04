package com.example.domain.error

sealed class AppError : Exception() {

    // Validation errors
    class EmptyFields : AppError()

    class InvalidPassword : AppError()


    // Network related errors
    class NoInternet : AppError()

    class Timeout : AppError()

    class Unauthorized : AppError()

    class Forbidden : AppError()

    class NotFound : AppError()

    class ServerError : AppError()

    class Unknown : AppError()
}