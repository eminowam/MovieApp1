package com.example.movieapp.domain.repository

import com.example.movieapp.domain.PersonDetails
import com.example.movieapp.domain.PersonResponse

interface PersonRepository {
    suspend fun getPerson(page: Int): PersonResponse

    suspend fun getPersonDetails(personId: Int): PersonDetails
}