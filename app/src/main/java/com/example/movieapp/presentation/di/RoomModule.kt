package com.example.movieapp.presentation.di

import androidx.room.Room
import com.example.movieapp.data.storage.db.models.MovieDataBase
import org.koin.dsl.module

const val APP_DATABASE_NAME = "application_database"

val roomModule = module {

    single {
        Room.databaseBuilder(get(), MovieDataBase::class.java, APP_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<MovieDataBase>().getMoviedao() }
}