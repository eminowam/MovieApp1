package com.example.movieapp.domain

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("poster_path") val poster: String,
    @SerializedName("title") val title: String,
    @SerializedName("original_language") val lang :String,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("budget") val budget: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("status") val status: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
)
