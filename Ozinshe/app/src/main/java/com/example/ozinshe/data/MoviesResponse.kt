package com.example.ozinshe.data


import com.google.gson.annotations.SerializedName

class MoviesResponse : ArrayList<MoviesResponse.MoviesResponseItem>(){
    data class MoviesResponseItem(
        @SerializedName("id")
        val id: Int,
        @SerializedName("movieType")
        val movieType: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("keyWords")
        val keyWords: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("year")
        val year: Int,
        @SerializedName("trend")
        val trend: Boolean,
        @SerializedName("timing")
        val timing: Int,
        @SerializedName("director")
        val director: String,
        @SerializedName("producer")
        val producer: String,
        @SerializedName("poster")
        val poster: Poster,
        @SerializedName("video")
        val video: Video,
        @SerializedName("watchCount")
        val watchCount: Int,
        @SerializedName("seasonCount")
        val seasonCount: Int,
        @SerializedName("seriesCount")
        val seriesCount: Int,
        @SerializedName("createdDate")
        val createdDate: String,
        @SerializedName("lastModifiedDate")
        val lastModifiedDate: String,
        @SerializedName("screenshots")
        val screenshots: List<Screenshot>,
        @SerializedName("categoryAges")
        val categoryAges: List<CategoryAge>,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("categories")
        val categories: List<Category>,
        @SerializedName("favorite")
        val favorite: Boolean
    ) {
        data class Poster(
            @SerializedName("id")
            val id: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("fileId")
            val fileId: Int,
            @SerializedName("movieId")
            val movieId: Int
        )
    
        data class Video(
            @SerializedName("id")
            val id: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("seasonId")
            val seasonId: Any,
            @SerializedName("number")
            val number: Int
        )
    
        data class Screenshot(
            @SerializedName("id")
            val id: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("fileId")
            val fileId: Int,
            @SerializedName("movieId")
            val movieId: Int
        )
    
        data class CategoryAge(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("fileId")
            val fileId: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("movieCount")
            val movieCount: Any
        )
    
        data class Genre(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("fileId")
            val fileId: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("movieCount")
            val movieCount: Any
        )
    
        data class Category(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("fileId")
            val fileId: Any,
            @SerializedName("link")
            val link: String,
            @SerializedName("movieCount")
            val movieCount: Any
        )
    }
}