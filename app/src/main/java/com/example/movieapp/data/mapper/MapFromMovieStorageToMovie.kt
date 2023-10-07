package com.example.movieapp.data.mapper

import com.example.movieapp.data.storage.models.MovieStorage
import com.example.movieapp.domain.Mapper
import com.example.movieapp.domain.Movie

class MapFromMovieStorageToMovie: Mapper<MovieStorage,Movie> {
    override fun map(from: MovieStorage)=from.run {
        Movie(
            movieId=movieId,
            title = originalTitle,
            releaseDate = releaseDate,
            posterImage = posterPath
        )
    }
}
class MapFromListMovieStorageToMovie(
    private val mapFromMovieStorageToMovie: MapFromMovieStorageToMovie
):Mapper<List<MovieStorage>,List<Movie>> {
    override fun map(from: List<MovieStorage>)=from.map {
        mapFromMovieStorageToMovie.map(it)
    }

}
