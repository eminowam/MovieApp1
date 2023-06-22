package com.example.movieapp.presentation.di

import com.example.movieapp.domain.moviesusecase.*
import com.example.movieapp.domain.personusecase.GetPersonDetailsUseCase
import com.example.movieapp.domain.personusecase.GetPersonUseCase
import com.example.movieapp.domain.storageusecase.*
import org.koin.dsl.module

val domainModule = module {

    factory {
        SaveMovieToStorage(repository = get())
    }
    factory {
        GetMovieDetailsUseCase(
            useCase = get()
        )
    }
    factory {
        GetPersonUseCase(
            repository = get()
        )
    }
    factory {
        GetPersonDetailsUseCase(
            repository = get()
        )
    }
    factory {
        GetSearghedMoviesUseCase(
            repository = get()
        )
    }
    factory {
        GetNowPlayingMoviesUseCase(
            repository = get()
        )
    }
    factory {
        GetPopularMoviesUseCase(
            repository = get()
        )
    }
    factory {
        GetUpcomingMoviesUseCase(
            repository = get()
        )
    }
    factory {
        GetTopRatedMoviesUseCase(
            repository = get()
        )
    }
    factory {
        GetStorageMoviesUseCase(
            repository = get()
        )
    }

    factory { GetDeleteUseCase(repository = get()) }
}