package com.example.movieapp.data.storage.db.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.storage.models.MovieStorage
import kotlinx.coroutines.selects.select

@Dao
interface MovieDao {

    @Query("SELECT * FROM MOVIE_STORAGE_TABLE")
    suspend fun getMovieList(): List<MovieStorage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovie(movieStorage: MovieStorage)

    @Query("DELETE  FROM MOVIE_STORAGE_TABLE WHERE movieId=:movieId")
    suspend fun deleteMovie(movieId: Int)
}