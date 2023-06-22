package com.example.movieapp.domain.moviesusecase

import com.example.movieapp.domain.MovieResponse
import com.example.movieapp.domain.repository.MoviesRepository

class GetNowPlayingMoviesUseCase(private val repository: MoviesRepository) {
    suspend operator fun invoke(page: Int): MovieResponse =
        repository.getNowPlayingMovies(page = page)
}