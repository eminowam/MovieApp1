package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repository.MovieRepositoryImpl
import com.example.movieapp.domain.moviesusecase.GetSearghedMoviesUseCase
import com.example.movieapp.domain.MovieResponse
import kotlinx.coroutines.launch

class SearchMoviesViewModel(private val useCaseSearch: GetSearghedMoviesUseCase): ViewModel() {

    private val _movie: MutableLiveData<MovieResponse> = MutableLiveData()
    val movie: LiveData<MovieResponse> get() = _movie

    private val repository = MovieRepositoryImpl()
    private val getSearchedMovieUseCase = GetSearghedMoviesUseCase(repository = repository)

    fun searchMovie(query: String) = viewModelScope.launch {
        kotlin.runCatching {
            getSearchedMovieUseCase.invoke(query = query)
        }.onSuccess {
            _movie.value = it
        }.onFailure {

        }

    }
}