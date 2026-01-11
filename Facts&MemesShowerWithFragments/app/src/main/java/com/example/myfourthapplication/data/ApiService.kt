package com.example.myfourthapplication.data

import retrofit2.http.GET

interface ApiService {
    @GET("/api/v2/facts/random")
    suspend fun getMemes(): FactBackResponse

    @GET("get_memes")
    suspend fun getMemes2(): MemesResponse

}