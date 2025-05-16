package com.example.movietvtracker.movies.data.remote

import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel

interface MoviesRemoteDataSource {
    suspend fun execute(): List<MovieRemoteModel>
}