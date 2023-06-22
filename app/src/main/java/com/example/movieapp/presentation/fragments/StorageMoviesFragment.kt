package com.example.movieapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentStorageMoviesBinding
import com.example.movieapp.domain.Movie
import com.example.movieapp.presentation.adapter.MovieSetOnClickListener
import com.example.movieapp.presentation.adapter.MoviesAdapter
import com.example.movieapp.presentation.viewmodels.StorageMoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StorageMoviesFragment : Fragment(), MovieSetOnClickListener<Movie> {

    private val binding by lazy {
        FragmentStorageMoviesBinding.inflate(layoutInflater)
    }

    private val viewModel: StorageMoviesViewModel by viewModel<StorageMoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    private val storageMoviesAdapter by lazy {
        MoviesAdapter(MoviesAdapter.ITEM_STORAGE, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRv()
        observeMovies()
    }
    private fun observeRv()= with(binding){
        recyclerViewStorage.adapter = storageMoviesAdapter
    }

    private fun observeMovies() = with(viewModel) {
        getSavedMovieList()
        movies.observe(viewLifecycleOwner) {
            storageMoviesAdapter.movies = it
        }
    }

    override fun goMovieDetails(movieId: Int) {
            findNavController().navigate(
                StorageMoviesFragmentDirections.actionBookmarkToMovieDetailsFragment(movieId.toString())
            )
    }

    override fun saveMovie(movie: Movie) {

    }
}