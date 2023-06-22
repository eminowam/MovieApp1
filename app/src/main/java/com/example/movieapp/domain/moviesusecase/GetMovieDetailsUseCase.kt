package com.example.movieapp.domain.moviesusecase

import com.example.movieapp.domain.MovieDetails
import com.example.movieapp.domain.repository.MoviesRepository

class GetMovieDetailsUseCase(private val useCase: MoviesRepository) {
    suspend fun invoke(movieId: Int): MovieDetails = useCase.getMovieDetails(movieId = movieId)
}