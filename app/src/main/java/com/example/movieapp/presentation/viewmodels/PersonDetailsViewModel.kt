package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.PersonDetails
import com.example.movieapp.domain.personusecase.GetPersonDetailsUseCase
import kotlinx.coroutines.launch

class PersonDetailsViewModel(private val useCasePersonDetails: GetPersonDetailsUseCase) : ViewModel() {

    private val _personDetails: MutableLiveData<PersonDetails> = MutableLiveData()
    val personDetails: LiveData<PersonDetails> get() = _personDetails

    fun personDetails(personId: Int) = viewModelScope.launch {
        _personDetails.value = useCasePersonDetails.invoke(personId = personId)
    }
}