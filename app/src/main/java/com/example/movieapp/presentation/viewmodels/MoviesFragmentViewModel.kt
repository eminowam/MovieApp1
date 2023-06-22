package com.example.movieapp.presentation.movie_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.*
import com.example.movieapp.domain.moviesusecase.GetNowPlayingMoviesUseCase
import com.example.movieapp.domain.moviesusecase.GetPopularMoviesUseCase
import com.example.movieapp.domain.moviesusecase.GetTopRatedMoviesUseCase
import com.example.movieapp.domain.moviesusecase.GetUpcomingMoviesUseCase
import com.example.movieapp.domain.storageusecase.*
import kotlinx.coroutines.launch

enum class MovieCategory {
    POPULAR, NOW_PLAYING, TOP_RATED, UPCOMING
}

class MoviesFragmentViewModel(private val useCasePopular: GetPopularMoviesUseCase,
                              private val useCaseNowPlaying: GetNowPlayingMoviesUseCase,
                              private val useCaseTopRated: GetTopRatedMoviesUseCase,
                              private val useCaseUpcoming: GetUpcomingMoviesUseCase,
                              private val saveMovieUseCase:SaveMovieToStorage,
) : ViewModel() {


    private val _moviePopular: MutableLiveData<MovieResponse> = MutableLiveData()
    val moviePopular: LiveData<MovieResponse> get() = _moviePopular

    private val _nowPlayingMovies: MutableLiveData<MovieResponse> = MutableLiveData()
    val nowPlayingMovies: LiveData<MovieResponse> get() = _nowPlayingMovies

    private val _topRatedMovies: MutableLiveData<MovieResponse> = MutableLiveData()
    val topRatedMovies: LiveData<MovieResponse> get() = _topRatedMovies

    private val _upcomingMovies: MutableLiveData<MovieResponse> = MutableLiveData()
    val upcomingMovies: LiveData<MovieResponse> get() = _upcomingMovies

    private var page = 1
    private var category: MovieCategory = MovieCategory.POPULAR

    init {
        getPopularMovie()
        getNowPlayingMovie()
        getTopRatedMovie()
        getUpcomingMovie()
    }

    fun saveMovie(movie: Movie) = viewModelScope.launch {
        saveMovieUseCase.invoke(movie)
    }

    fun getMovies(movieCategory: MovieCategory) {
        if (category != movieCategory) {
            page = 1
            category = movieCategory
        }
        when (movieCategory) {
            MovieCategory.POPULAR -> getPopularMovie()
            MovieCategory.NOW_PLAYING -> getNowPlayingMovie()
            MovieCategory.TOP_RATED -> getTopRatedMovie()
            MovieCategory.UPCOMING -> getUpcomingMovie()
        }
    }

    private fun getPopularMovie() = viewModelScope.launch {
        _moviePopular.value = useCasePopular.invoke(page = page)
    }

    private fun getNowPlayingMovie() = viewModelScope.launch {
        _nowPlayingMovies.value = useCaseNowPlaying.invoke(page = page)
    }

    private fun getUpcomingMovie() = viewModelScope.launch {
        _upcomingMovies.value = useCaseUpcoming.invoke(page = page)
    }

    private fun getTopRatedMovie() = viewModelScope.launch {
        _topRatedMovies.value = useCaseTopRated.invoke(page = page)
    }


}