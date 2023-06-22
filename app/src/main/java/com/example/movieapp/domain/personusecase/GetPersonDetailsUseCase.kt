package com.example.movieapp.domain.personusecase

import com.example.movieapp.domain.PersonDetails
import com.example.movieapp.domain.repository.PersonRepository

class GetPersonDetailsUseCase(private val repository: PersonRepository) {
    suspend fun invoke(personId: Int): PersonDetails = repository.getPersonDetails(personId)
}