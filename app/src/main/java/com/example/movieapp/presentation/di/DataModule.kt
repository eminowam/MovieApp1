package com.example.movieapp.presentation.di

import com.example.movieapp.data.mapper.MapFromListMovieStorageToMovie
import com.example.movieapp.data.mapper.MapFromMovieStorageToMovie
import com.example.movieapp.data.mapper.MapFromMovieStorageToMovie2
import com.example.movieapp.data.repository.MovieRepositoryImpl
import com.example.movieapp.data.repository.MovieStorageRepositoryImpl
import com.example.movieapp.data.repository.PersonRepositoryImpl
import com.example.movieapp.domain.repository.MovieStorageRepository
import com.example.movieapp.domain.repository.MoviesRepository
import com.example.movieapp.domain.repository.PersonRepository
import org.koin.dsl.module

val dataModule = module {
    single<MoviesRepository> {
        MovieRepositoryImpl()
    }
    single<PersonRepository>{
        PersonRepositoryImpl()
    }
    single<MovieStorageRepository> {
        MovieStorageRepositoryImpl(
            dao = get(),
            mapFromListMovieStorageToListMovie = MapFromListMovieStorageToMovie
                (mapFromMovieStorageToMovie= MapFromMovieStorageToMovie()),
            mapFromMovieStorageToMovie2=MapFromMovieStorageToMovie2(),
        )
    }
}