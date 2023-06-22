package com.example.movieapp.domain

interface Mapper<From, To> {
    fun map(from: From): To
}