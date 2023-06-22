package com.example.movieapp.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieapp.data.network.utils.api.Utils
import com.example.movieapp.databinding.FragmentPersonDetailsBinding
import com.example.movieapp.domain.PersonDetails
import com.example.movieapp.presentation.movie_screen.MoviesFragmentViewModel
import com.example.movieapp.presentation.viewmodels.PersonDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentPersonDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel :PersonDetailsViewModel by viewModel<PersonDetailsViewModel>()

     private val personId: Int by lazy(LazyThreadSafetyMode.NONE) {
        PersonDetailsFragmentArgs.fromBundle(requireArguments()).personId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.personDetails.observe(viewLifecycleOwner) { person ->
            observeData(person)
        }
        viewModel.personDetails(personId = personId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    private fun observeData(person: PersonDetails) = with(viewModel) {
        viewModel.personDetails.observe(viewLifecycleOwner) {
            binding.apply {
                nameActor.text = person.name
                birthday.text = person.birthday
                Glide.with(this@PersonDetailsFragment).load(Utils.IMAGE_URL + person.profile_path)
                    .centerCrop()
                    .into(backpath);
                deathday.text = person.deathday
                placeOfBirth.text = person.place_of_birth
                popularyActors.text = person.popularity.toString()
                homePage.text = person.homepage
                departament.text = person.known_for_department
                gender.text = person.gender
                biography.text = person.biography
            }
        }
    }
}