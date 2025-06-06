package com.example.movietvtracker.movies.presentation.model

import java.util.Date

data class MovieDisplayModel(
    val id: Long,
    val description: String,
    val poster: String,
    val releaseDate: Date?,
    val title: String,
)
