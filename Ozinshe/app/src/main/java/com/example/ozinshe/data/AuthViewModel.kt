package com.example.ozinshe.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    fun signIn(email: String, password: String, onResult: (AuthSignInResponse?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = repository.signIn(email, password)
                onResult(response)
            } catch (e: Exception) {
                onResult(null)
            }
        }
    }
}