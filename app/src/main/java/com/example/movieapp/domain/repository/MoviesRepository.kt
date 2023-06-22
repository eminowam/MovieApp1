package com.example.movieapp.domain.repository

import com.example.movieapp.domain.MovieDetails
import com.example.movieapp.domain.MovieResponse

interface MoviesRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse

    suspend fun getNowPlayingMovies(page: Int): MovieResponse

    suspend fun getTopRatedMovies(page: Int): MovieResponse

    suspend fun getUpcomingMovies(page: Int): MovieResponse

    suspend fun getSearchedMovies(query:String): MovieResponse

    suspend fun getMovieDetails(movieId:Int): MovieDetails
}