package com.example.movieapp.data.repository

import com.example.movieapp.data.storage.db.models.MovieDao
import com.example.movieapp.data.storage.models.MovieStorage
import com.example.movieapp.domain.Mapper
import com.example.movieapp.domain.Movie
import com.example.movieapp.domain.repository.MovieStorageRepository

class MovieStorageRepositoryImpl(
    private val dao: MovieDao,
    private val mapFromListMovieStorageToListMovie: Mapper<List<MovieStorage>, List<Movie>>,
    private val mapFromMovieStorageToMovie2: Mapper<Movie,MovieStorage>
) : MovieStorageRepository {

    override suspend fun getMovieList(): List<Movie> =
        mapFromListMovieStorageToListMovie.map(dao.getMovieList())


    override suspend fun saveMovie(movie: Movie) =
        dao.saveMovie(mapFromMovieStorageToMovie2.map(movie))


    override suspend fun deleteMovie(movieId: Int) = dao.deleteMovie(movieId)

}