package com.example.movieapp.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_storage_table")
class MovieStorage(
    @PrimaryKey(autoGenerate = true) val movieId: Int,
    @ColumnInfo val posterPath: String?,
    @ColumnInfo val releaseDate: Boolean,
    @ColumnInfo val originalTitle: String,
)