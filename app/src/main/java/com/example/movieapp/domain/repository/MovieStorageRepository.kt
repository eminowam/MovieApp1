package com.example.movieapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.movieapp.domain.Movie

interface MovieStorageRepository {
    suspend fun getMovieList(): List<Movie>
    suspend fun saveMovie(movie: Movie)
    suspend fun deleteMovie(movieId: Int)
}