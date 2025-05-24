package com.example.movietvtracker.movies.domain.model

data class MovieDomainModel(
    val id: Long,
    val overview: String,
    val poster: String,
    val releaseDate: String,
    val title: String,
)
