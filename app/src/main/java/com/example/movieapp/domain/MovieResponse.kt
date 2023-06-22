package com.example.movieapp.domain


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int,

)

data class PersonResponse(
    @SerializedName("page") val page:Int,
    @SerializedName("results") val person:List<Person>,
    @SerializedName("total_pages") val totalResult:Int,
)