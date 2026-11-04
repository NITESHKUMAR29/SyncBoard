package com.example.network.apiInterface

import com.example.network.dto.AuthResponseDto
import com.example.network.dto.LoginRequestDto
import com.example.network.dto.SignUpRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SyncBoardApi {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequestDto): Response<AuthResponseDto>

    @POST("auth/register")
    suspend fun register(@Body signUpRequest: SignUpRequestDto): Response<AuthResponseDto>

}