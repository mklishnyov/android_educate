package com.example.ozinshe.data

class AuthRepository(private val apiService: ApiService) {
    suspend fun signUp(email: String, password: String, username: String): SignUpResponse {
        return apiService.signUp(SignUpRequest(email, password, username))
    }
}