package com.example.movieapp.domain.personusecase

import com.example.movieapp.domain.repository.PersonRepository
import com.example.movieapp.domain.PersonResponse

class GetPersonUseCase(private val repository: PersonRepository) {
    suspend fun invoke(page:Int): PersonResponse =
        repository.getPerson(page = page)
}