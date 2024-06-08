package com.example.ozinshe.data


import com.google.gson.annotations.SerializedName

data class SignInUpResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("tokenType")
    val tokenType: String
)
data class SignInUpRequest(
    val email: String,
    val password: String,
)