package com.example.movieapp.data.repository

import com.example.movieapp.data.RetrofitInstance
import com.example.movieapp.domain.MovieDetails
import com.example.movieapp.domain.MovieResponse
import com.example.movieapp.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl : MoviesRepository {
    val api = RetrofitInstance.api


    override suspend fun getPopularMovies(page: Int): MovieResponse =
        api.getPopularMovie(page = page).body()!!


    override suspend fun getNowPlayingMovies(page: Int): MovieResponse =
        withContext(Dispatchers.IO) {
            api.getNowPlayingMovie(page = page).body()!!
        }

    override suspend fun getTopRatedMovies(page: Int): MovieResponse =
        withContext(Dispatchers.IO) {
            api.getTopRatedMovie(page = page).body()!!
        }

    override suspend fun getUpcomingMovies(page: Int): MovieResponse =
        withContext(Dispatchers.IO) {
            api.getUpcomingMovie(page = page).body()!!
        }

    override suspend fun getSearchedMovies(query: String):MovieResponse {
        return withContext(Dispatchers.IO) {
            api.getSearchedMovies(query = query).body()!!
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails =
        withContext(Dispatchers.IO) {
            api.getDetailsMovies(movie_id = movieId).body()!!
        }
}

