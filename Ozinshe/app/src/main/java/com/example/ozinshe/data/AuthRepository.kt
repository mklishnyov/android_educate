package com.example.ozinshe.data

class AuthRepository(private val apiService: ApiService) {
    suspend fun signUp(email: String, password: String): SignInUpResponse {
        return apiService.signUp(SignInUpRequest(email, password))
    }
    suspend fun signIn(email: String, password: String): SignInUpResponse {
        return apiService.signIn(SignInUpRequest(email, password))
    }
}