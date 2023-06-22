package com.example.movieapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentSearchMoviesBinding
import com.example.movieapp.domain.Movie
import com.example.movieapp.presentation.adapter.MovieSetOnClickListener
import com.example.movieapp.presentation.adapter.MoviesAdapter
import com.example.movieapp.presentation.viewmodels.SearchMoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchMoviesFragment : Fragment(), MovieSetOnClickListener<Movie> {

    private val binding by lazy {
        FragmentSearchMoviesBinding.inflate(layoutInflater)
    }

    private val viewModel: SearchMoviesViewModel by viewModel<SearchMoviesViewModel>()

    private val adapter by lazy {
        MoviesAdapter(listener = this, itemType = MoviesAdapter.ITEM_MOVIE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()

        searchMovie()
    }

    private fun observeData() = with(viewModel) {
        movie.observe(viewLifecycleOwner) {
            adapter.movies = it.movies
        }
        binding.searchViewRv.adapter = adapter
    }

    private fun searchMovie() {
        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchMovie(newText!!)
                return false
            }

        })
        binding.searchView.setOnCloseListener { false }
    }

    override fun goMovieDetails(movieId: Int) {
        findNavController().navigate(
            SearchMoviesFragmentDirections.actionSearchScreenToMovieDetailsFragment(movieId.toString())
        )
    }

    override fun saveMovie(movie: Movie) {

    }
}
