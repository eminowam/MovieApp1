package com.example.movieapp.domain.storageusecase

import com.example.movieapp.domain.repository.MovieStorageRepository

class GetDeleteUseCase(private val repository: MovieStorageRepository) {
    suspend fun invoke(movieId:Int) = repository.deleteMovie(movieId)

}

