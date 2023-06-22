package com.example.movieapp.domain.storageusecase

import com.example.movieapp.domain.Movie
import com.example.movieapp.domain.repository.MovieStorageRepository

class SaveMovieToStorage(private val repository: MovieStorageRepository) {
    suspend fun invoke(movie: Movie) = repository.saveMovie(movie)

}