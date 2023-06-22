package com.example.movieapp.domain

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id") val personId: Int,
    @SerializedName("profile_path") val profile_path: String,
    @SerializedName("name") val name: String,
)