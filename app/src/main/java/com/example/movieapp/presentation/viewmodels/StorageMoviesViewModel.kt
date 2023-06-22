package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.movieapp.data.repository.MovieStorageRepositoryImple
import com.example.movieapp.domain.Movie
import com.example.movieapp.domain.storageusecase.GetStorageMoviesUseCase
import kotlinx.coroutines.launch

class StorageMoviesViewModel(
    private val useCaseSaveStorage: GetStorageMoviesUseCase,
    private val useCaseDelete: GetStorageMoviesUseCase
) : ViewModel() {

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>> get() = _movies

    fun getSavedMovieList() = viewModelScope.launch {
        kotlin.runCatching {
            useCaseSaveStorage.invoke()
        }.onSuccess {
            _movies.value = it
        }
    }
}