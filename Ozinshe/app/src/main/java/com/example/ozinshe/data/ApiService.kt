package com.example.ozinshe.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/V1/signup")
    suspend fun signUp(@Body request: SignInUpRequest): SignInUpResponse

    @POST("/auth/V1/signin")
    suspend fun signIn(@Body request: SignInUpRequest): SignInUpResponse

    @GET("/core/V1/movies")
    suspend fun getMovies(): List<MoviesResponse.MoviesResponseItem>

}
