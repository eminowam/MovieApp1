package com.example.movieapp

import android.app.Application
import com.example.movieapp.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(
              dataModule,
                domainModule,
                presentationModule,
                roomModule,
            networkModule)
            )
        }
    }
}