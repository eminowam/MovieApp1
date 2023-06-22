package com.example.movieapp.domain.storageusecase

import com.example.movieapp.domain.repository.MovieStorageRepository

class GetStorageMoviesUseCase(private val repository: MovieStorageRepository) {
    suspend operator fun invoke() = repository.getMovieList()
}