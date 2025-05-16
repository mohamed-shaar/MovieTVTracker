package com.example.movietvtracker.movies.data.remote.model

data class MovieRemoteModel(
    val id: Long,
    val overview: String,
    val poster: String?,
    val releaseDate: String,
    val title: String,
)
