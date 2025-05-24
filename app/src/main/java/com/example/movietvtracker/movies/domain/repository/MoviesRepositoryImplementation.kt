package com.example.movietvtracker.movies.domain.repository

import com.example.movietvtracker.movies.data.remote.MoviesRemoteDataSource
import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel

class MoviesRepositoryImplementation(private val moviesRemoteDataSource: MoviesRemoteDataSource) :
    MoviesRepository {
    override suspend fun getMovies(): List<MovieRemoteModel> {
        return moviesRemoteDataSource.execute()
    }
}