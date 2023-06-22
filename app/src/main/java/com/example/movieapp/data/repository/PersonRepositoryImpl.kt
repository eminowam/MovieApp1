package com.example.movieapp.data.repository

import com.example.movieapp.data.RetrofitInstance
import com.example.movieapp.domain.PersonDetails
import com.example.movieapp.domain.repository.PersonRepository
import com.example.movieapp.domain.PersonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonRepositoryImpl : PersonRepository {
    val api = RetrofitInstance.api

    override suspend fun getPerson(page: Int): PersonResponse =
        withContext(Dispatchers.IO) {
        api.getPerson(page = page)
    }.body()!!

    override suspend fun getPersonDetails(personId: Int): PersonDetails =
        withContext(Dispatchers.IO) {
            api.getDetailsPerson(person_id = personId)
        }.body()!!
}