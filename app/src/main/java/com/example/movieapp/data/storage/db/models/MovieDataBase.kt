package com.example.movieapp.data.storage.db.models

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.data.storage.models.MovieStorage

private const val DB_NAME = "movie_item.db"

@Database(entities = [MovieStorage::class], version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun getMoviedao(): MovieDao

    companion object {
        private var INSTANCE: MovieDataBase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): MovieDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    MovieDataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }

}