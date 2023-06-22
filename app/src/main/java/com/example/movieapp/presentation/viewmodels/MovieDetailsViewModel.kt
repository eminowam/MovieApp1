package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.moviesusecase.GetMovieDetailsUseCase
import com.example.movieapp.domain.MovieDetails
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val useCase: GetMovieDetailsUseCase
) : ViewModel() {

//    private val movieDetailsUseCase = GetMovieDetailsUseCase(reposytory)

    private val _movieDetails: MutableLiveData<MovieDetails> = MutableLiveData()
    val movieDetails: LiveData<MovieDetails> get() = _movieDetails

    fun movieDetails(movieId: Int) = viewModelScope.launch {
        _movieDetails.value = useCase.invoke(movieId = movieId)
    }
}