package com.example.movieapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentMoviesBinding
import com.example.movieapp.domain.Movie
import com.example.movieapp.presentation.adapter.MovieSetOnClickListener
import com.example.movieapp.presentation.adapter.MoviesAdapter
import com.example.movieapp.presentation.movie_screen.MoviesFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment(), MovieSetOnClickListener<Movie> {

    private val binding by lazy { FragmentMoviesBinding.inflate(layoutInflater) }

    private val viewModel: MoviesFragmentViewModel by viewModel<MoviesFragmentViewModel>()

    private val moviesPopularAdapter by lazy {
        MoviesAdapter(
            itemType = MoviesAdapter.ITEM_MOVIE,
            listener = this
        )
    }
    private val moviesNowPlayingAdapter by lazy {
        MoviesAdapter(
            itemType = MoviesAdapter.ITEM_MOVIE,
            listener = this
        )
    }
    private val moviesTopRatedAdapter by lazy {
        MoviesAdapter(
            itemType = MoviesAdapter.ITEM_MOVIE,
            listener = this
        )
    }
    private val moviesUpcomingAdapter by lazy {
        MoviesAdapter(
            itemType = MoviesAdapter.ITEM_MOVIE,
            listener = this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        observeRv()
    }

    private fun observeViewModel() = with(viewModel) {
        moviePopular.observe(viewLifecycleOwner) {
            moviesPopularAdapter.movies = it.movies
        }
        nowPlayingMovies.observe(viewLifecycleOwner) {
            moviesNowPlayingAdapter.movies = it.movies
        }
        topRatedMovies.observe(viewLifecycleOwner) {
            moviesTopRatedAdapter.movies = it.movies
        }
        upcomingMovies.observe(viewLifecycleOwner) {
            moviesUpcomingAdapter.movies = it.movies
        }
    }

    private fun observeRv() {
        binding.popularMoviesRv.adapter = moviesPopularAdapter
        binding.nowPlayingMoviesRv2.adapter = moviesNowPlayingAdapter
        binding.topRatedMoviesRv2.adapter = moviesTopRatedAdapter
        binding.upcomingMoviesRv2.adapter = moviesUpcomingAdapter
    }

    override fun goMovieDetails(movieId: Int) {
        findNavController().navigate(
            MoviesFragmentDirections.actionHomePageToMovieDetailsFragment(movieId.toString())
        )
    }
    override fun saveMovie(movie: Movie) {
        viewModel.saveMovie(movie)
        Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
    }
}