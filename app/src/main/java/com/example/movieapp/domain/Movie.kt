package com.example.movieapp.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("poster_path") val posterImage: String?,
    @SerializedName("release_date") val releaseDate: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("id") val movieId: Int,
)