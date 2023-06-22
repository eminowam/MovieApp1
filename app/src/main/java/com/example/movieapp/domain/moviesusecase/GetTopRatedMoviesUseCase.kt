package com.example.movieapp.domain.moviesusecase

import com.example.movieapp.domain.MovieResponse
import com.example.movieapp.domain.repository.MoviesRepository

class GetTopRatedMoviesUseCase(private val repository: MoviesRepository) {
    suspend operator fun invoke(page: Int): MovieResponse =
        repository.getTopRatedMovies(page = page)
}