package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.personusecase.GetPersonUseCase
import com.example.movieapp.domain.PersonResponse
import kotlinx.coroutines.launch

class ActorsViewModel(private val useCase: GetPersonUseCase) : ViewModel() {
    private var page = 1
//    private val personRepository = PersonRepositoryImpl()

//    private val getPersonUseCase = GetPersonUseCase(personRepository)

    private val _person: MutableLiveData<PersonResponse> = MutableLiveData()
    val person: MutableLiveData<PersonResponse> get() = _person

    init {
        personMovie()
    }

    private fun personMovie() = viewModelScope.launch {
        kotlin.runCatching {
            useCase.invoke(page = page)
        }.onSuccess {
            _person.value = it
        }.onFailure {

        }
    }
}