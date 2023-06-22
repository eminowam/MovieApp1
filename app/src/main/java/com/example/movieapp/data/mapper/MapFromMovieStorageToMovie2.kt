package com.example.movieapp.data.mapper

import com.example.movieapp.data.storage.models.MovieStorage
import com.example.movieapp.domain.Mapper
import com.example.movieapp.domain.Movie

class MapFromMovieStorageToMovie2 : Mapper<Movie, MovieStorage> {
    override fun map(from: Movie) = from.run {
        MovieStorage(
            movieId = movieId,
            posterPath = posterImage,
            originalTitle = title,
            releaseDate = releaseDate
        )
    }
}