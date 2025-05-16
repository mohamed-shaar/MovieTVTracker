package com.example.movietvtracker.movies.domain.repository

import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel

interface MoviesRepository {
    suspend fun getMovies(): List<MovieRemoteModel>
}