package com.example.movietvtracker.movies.di

import com.example.movietvtracker.movies.domain.repository.MoviesRepository
import com.example.movietvtracker.movies.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDI {

    @Provides
    @Singleton
    fun provideGetMovies(
        moviesRepository: MoviesRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(
            moviesRepository = moviesRepository,
        )
    }

}