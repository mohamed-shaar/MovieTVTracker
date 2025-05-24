package com.example.movietvtracker.movies.domain.usecase

import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel
import com.example.movietvtracker.movies.domain.mapper.MovieRemoteToDomainMapper
import com.example.movietvtracker.movies.domain.model.MovieDomainModel
import com.example.movietvtracker.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val movieMapper: MovieRemoteToDomainMapper,
) {
    suspend fun execute(): List<MovieDomainModel> {
        val remoteMovies: List<MovieRemoteModel> = moviesRepository.getMovies()
        val domainMovies: List<MovieDomainModel> = remoteMovies.map {
            movieMapper(it)
        }
        return domainMovies
    }
}