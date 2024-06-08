package com.example.ozinshe.data

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/V1/signup")
    suspend fun signUp(@Body request: SignInUpRequest): SignInUpResponse

    @POST("/auth/V1/signin")
    suspend fun signIn(@Body request: SignInUpRequest): SignInUpResponse
}

data class SignInUpRequest(
    val email: String,
    val password: String,
)

data class SignInUpResponse(
    val id: Int,
    val username: String,
    val email: String,
    val roles: List<String>,
    val accessToken: String,
    val tokenType: String
)