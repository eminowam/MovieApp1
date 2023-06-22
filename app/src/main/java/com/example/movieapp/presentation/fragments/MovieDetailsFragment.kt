package com.example.movieapp.presentation.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.movieapp.data.network.utils.api.Utils
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.domain.MovieDetails
import com.example.movieapp.presentation.activity.MovieDetailsActivity
import com.example.movieapp.presentation.viewmodels.MovieDetailsViewModel
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentMovieDetailsBinding.inflate(layoutInflater)
    }
    private val viewModel : MovieDetailsViewModel by viewModel<MovieDetailsViewModel>()

    private val movieId: String by lazy(LazyThreadSafetyMode.NONE) {
        MovieDetailsFragmentArgs.fromBundle(requireArguments()).id
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movieDetails.observe(viewLifecycleOwner) { movie ->
            observeUi(movie)
        }
     viewModel.movieDetails(movieId = movieId.toInt() )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    private fun observeUi(movie: MovieDetails) = with(binding) {
        title.text = movie.title
        budjetText.text = movie.budget.toString()
        Glide.with(this@MovieDetailsFragment).load(Utils.IMAGE_URL + movie.backdrop_path).centerCrop()
            .into(backpath);
        Glide.with(this@MovieDetailsFragment).load(Utils.IMAGE_URL + movie.poster).centerCrop()
            .into(poster)
        popularityText.text = movie.popularity.toString()
        langOrig.text = movie.lang
        originalTitle.text = movie.originalTitle
        release_date.text = movie.releaseDate
        runtime.text = movie.runtime.toString()
        status.text = movie.status
        descMovie.text=movie.overview
    }
    companion object {
        private const val MOVIE_ID = "movie_id"
        fun startIntentToMovieDetailActivity(context: Context, movieId: Int): Intent =
            Intent(context, MovieDetailsActivity::class.java).apply {
                bundleOf().apply { putExtra(MOVIE_ID, movieId) }
            }
    }
}