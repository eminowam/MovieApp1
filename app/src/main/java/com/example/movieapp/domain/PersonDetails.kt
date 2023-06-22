package com.example.movieapp.domain

import com.google.gson.annotations.SerializedName

class PersonDetails(
    @SerializedName("profile_path") val profile_path: String,
    @SerializedName("name") val name: String,
    @SerializedName("place_of_birth") val place_of_birth: String,
    @SerializedName("popularity") val popularity: String,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("known_for_department") val known_for_department: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("deathday") val deathday: String?,
    @SerializedName("biography") val biography: String,
)