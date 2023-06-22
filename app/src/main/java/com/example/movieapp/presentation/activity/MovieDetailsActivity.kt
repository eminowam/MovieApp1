package com.example.movieapp.presentation.activity

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.movieapp.data.network.utils.api.Utils
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.domain.MovieDetails
import com.example.movieapp.presentation.viewmodels.MovieDetailsViewModel
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        FragmentMovieDetailsBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }

    private val movieId: Int by lazy(LazyThreadSafetyMode.NONE) {
        intent.getIntExtra(MOVIE_ID, 1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.movieDetails.observe(this) { movie ->
            observeUi(movie)
        }
        viewModel.movieDetails(movieId)
    }

    private fun observeUi(movie: MovieDetails) = with(binding) {
        title.text = movie.title
        budjetText.text = movie.budget.toString()
        Glide.with(applicationContext).load(Utils.IMAGE_URL + movie.backdrop_path).centerCrop()
            .into(backpath);
        Glide.with(applicationContext).load(Utils.IMAGE_URL + movie.poster).centerCrop()
            .into(poster)
        popularityText.text = movie.popularity.toString()
        langOrig.text = movie.lang
        originalTitle.text = movie.originalTitle
        release_date.text = movie.releaseDate
        runtime.text = movie.runtime.toString()
        status.text = movie.status
    }

    companion object {
        private const val MOVIE_ID = "movie_id"
        fun startIntentToMovieDetailActivity(context: Context, movieId: Int): Intent =
            Intent(context, MovieDetailsActivity::class.java).apply {
                bundleOf().apply { putExtra(MOVIE_ID, movieId) }
            }
    }
}