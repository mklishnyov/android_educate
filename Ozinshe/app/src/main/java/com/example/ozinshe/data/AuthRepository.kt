package com.example.ozinshe.data

class AuthRepository(private val apiService: ApiService) {
    suspend fun signIn(email: String, password: String): AuthSignInResponse {
        return apiService.signIn(SignInRequest(email, password))
    }
}