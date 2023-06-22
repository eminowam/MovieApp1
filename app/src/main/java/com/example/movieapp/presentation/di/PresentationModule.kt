package com.example.movieapp.presentation.di

import com.example.movieapp.presentation.fragments.MoviesFragment
import com.example.movieapp.presentation.movie_screen.MoviesFragmentViewModel
import com.example.movieapp.presentation.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        MovieDetailsViewModel(
            useCase = get()
        )
    }
    viewModel {
        MoviesFragmentViewModel(
            useCaseNowPlaying = get(),
            useCasePopular = get(),
            useCaseTopRated = get(),
            useCaseUpcoming = get(),
            saveMovieUseCase = get()
        )
    }
    viewModel {
        ActorsViewModel(
            useCase = get()
        )
    }
    viewModel {
        SearchMoviesViewModel(
            useCaseSearch = get()
        )
    }
    viewModel {
        PersonDetailsViewModel(
            useCasePersonDetails = get()
        )
    }
    viewModel {
        StorageMoviesViewModel(
            useCaseSaveStorage = get(),
            useCaseDelete = get()
        )
    }
}