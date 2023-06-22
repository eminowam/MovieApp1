package com.example.movieapp.data.network.utils.api

import com.example.movieapp.data.network.utils.api.Endpoints.PERSON
import com.example.movieapp.data.network.utils.api.Endpoints.PERSON_DETAILS
import com.example.movieapp.data.network.utils.api.Endpoints.SEARCH_MOVIE
import com.example.movieapp.data.network.utils.api.Utils.API_KEY
import com.example.movieapp.domain.MovieDetails
import com.example.movieapp.domain.MovieResponse
import com.example.movieapp.domain.PersonDetails
import com.example.movieapp.domain.PersonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET(Endpoints.POPULAR)
    suspend fun getPopularMovie(
        @Query("page") page: Int,
        @Query("language") language: String = "ru",
        @Query("api_key") apiKey: String = Utils.API_KEY
    ): Response<MovieResponse>

    @GET(Endpoints.NOW_PLAYING)
    suspend fun getNowPlayingMovie(
        @Query("page") page: Int,
        @Query("language") language: String = "ru",
        @Query("api_key") apiKey: String = Utils.API_KEY,
    ): Response<MovieResponse>

    @GET(Endpoints.TOP_RATED)
    suspend fun getTopRatedMovie(
        @Query("page") page: Int,
        @Query("language") language: String = "ru",
        @Query("api_key") apiKey: String = Utils.API_KEY,
    ): Response<MovieResponse>

    @GET(Endpoints.UPCOMING)
    suspend fun getUpcomingMovie(
        @Query("page") page: Int,
        @Query("language") language: String = "ru",
        @Query("api_key") apiKey: String = Utils.API_KEY,
    ): Response<MovieResponse>


    @GET(SEARCH_MOVIE)
    suspend fun getSearchedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("query") query: String,
        @Query("language") language: String = "ru",
    ): Response<MovieResponse>

    @GET(Endpoints.MOVIE_DETAILS)
    suspend fun getDetailsMovies(
        @Path("movie_id") movie_id: Int,
        @Query("language") language: String = "ru",
        @Query("api_key") apiKey: String = Utils.API_KEY,
        @Query("page") page: Int = 1
    ): Response<MovieDetails>

    @GET(PERSON)
    suspend fun getPerson(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int,
        @Query("language") language: String = "ru",
    ): Response<PersonResponse>

    @GET(PERSON_DETAILS)
    suspend fun getDetailsPerson(
        @Path("person_id") person_id: Int,
        @Query("language") language: String = "ru",
        @Query("api_key") apiKey: String = Utils.API_KEY,
        @Query("page") page: Int = 1
    ): Response<PersonDetails>

}