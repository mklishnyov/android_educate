package com.example.ozinshe.data

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/V1/signup")
    suspend fun signUp(@Body request: SignUpRequest): SignUpResponse
}

data class SignUpRequest(
    val email: String,
    val password: String,
    val username: String
)

data class SignUpResponse(
    val id: Int,
    val email: String,
    val username: String,
    val roles: List<String>,
    val accessToken: String,
    val tokenType: String
)