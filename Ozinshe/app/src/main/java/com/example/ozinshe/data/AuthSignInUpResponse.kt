package com.example.ozinshe.data


import com.google.gson.annotations.SerializedName

data class AuthSignInUpResponse(
    @SerializedName("id")
    val id: Int, // 25717
    @SerializedName("username")
    val username: String, // string12345@gmail.com
    @SerializedName("email")
    val email: String, // string12345@gmail.com
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("accessToken")
    val accessToken: String, // eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmcxMjM0NUBnbWFpbC5jb20iLCJpYXQiOjE3MTc3NjgzODIsImV4cCI6MTc0OTMwNDM4Mn0.m4QnvF2BzgkqcvQkW5SI7dyVc3Mqyfuv8PrEsTJkvxjoAehv7tWw4mRrMJwG9V1-sAF97kiOGO0tScJGhWaAqg
    @SerializedName("tokenType")
    val tokenType: String // Bearer
)