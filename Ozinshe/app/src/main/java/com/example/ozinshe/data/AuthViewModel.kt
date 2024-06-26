package com.example.ozinshe.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    fun signUp(email: String, password: String, onResult: (SignInUpResponse?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = repository.signUp(email, password)
                onResult(response)
            } catch (e: Exception) {
                onResult(null)
            }
        }
    }

    fun signIn(email: String, password: String, onResult: (SignInUpResponse?) -> Unit) {
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

class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}