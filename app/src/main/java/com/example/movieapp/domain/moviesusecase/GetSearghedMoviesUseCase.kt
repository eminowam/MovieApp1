package com.example.movieapp.domain.moviesusecase

import com.example.movieapp.domain.repository.MoviesRepository

class GetSearghedMoviesUseCase(private val repository: MoviesRepository) {
    suspend  fun invoke(query: String) = repository.getSearchedMovies(query = query)
}