package com.example.movietvtracker.movies.di

import com.example.movietvtracker.movies.data.remote.MoviesRemoteDataSource
import com.example.movietvtracker.movies.data.remote.TheMovieDBRemoteDatasource
import com.example.movietvtracker.movies.domain.repository.MoviesRepository
import com.example.movietvtracker.movies.domain.repository.MoviesRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesNetworkDI {

    @Provides
    @Singleton
    fun provideMoviesDBRemoteDatasource(): MoviesRemoteDataSource {
        return TheMovieDBRemoteDatasource()
    }

    @Provides
    @Singleton
    fun provideMoviesRepositories(moviesRemoteDataSource: MoviesRemoteDataSource): MoviesRepository {
        return MoviesRepositoryImplementation(
            moviesRemoteDataSource = moviesRemoteDataSource
        )
    }

}