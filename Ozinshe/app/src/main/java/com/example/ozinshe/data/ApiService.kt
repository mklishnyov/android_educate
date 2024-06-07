package com.example.ozinshe.data

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/V1/signin")
    suspend fun signIn(@Body request: SignInRequest): AuthSignInResponse

}