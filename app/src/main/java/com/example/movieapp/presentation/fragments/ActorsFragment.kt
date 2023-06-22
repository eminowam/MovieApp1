package com.example.movieapp.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentActorsBinding
import com.example.movieapp.presentation.adapter.personsadapter.MovieSetOnClickListener
import com.example.movieapp.presentation.adapter.personsadapter.PersonAdapter
import com.example.movieapp.presentation.viewmodels.ActorsViewModel
import com.example.movieapp.presentation.viewmodels.MovieDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActorsFragment : Fragment(), AdapterView.OnItemSelectedListener, MovieSetOnClickListener {

    private val binding by lazy {
        FragmentActorsBinding.inflate(layoutInflater)
    }

    private val viewModel: ActorsViewModel by viewModel<ActorsViewModel>()

    private val personAdapter by lazy {
        PersonAdapter(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.person.observe(viewLifecycleOwner) {
            personAdapter.person = it.person
        }
        binding.personRv.adapter = personAdapter
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun goPersonDetails(page: Int) {
        findNavController().navigate(
            ActorsFragmentDirections.actionActorsPageToPersonDetailsFragment(page)
        )
    }
}
