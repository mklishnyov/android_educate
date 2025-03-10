package com.example.ozinshe.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<MoviesResponse.MoviesResponseItem>>()
    val movies: LiveData<List<MoviesResponse.MoviesResponseItem>> = _movies

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getMovies()
                _movies.postValue(response)
            } catch (e: Exception) {
            }
        }
    }
}
