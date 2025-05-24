package com.example.movietvtracker.movies.di

import com.example.movietvtracker.movies.domain.mapper.MovieRemoteToDomainMapper
import com.example.movietvtracker.movies.domain.mapper.MovieRemoteToDomainMapperImpl
import com.example.movietvtracker.movies.domain.repository.MoviesRepository
import com.example.movietvtracker.movies.domain.usecase.GetMoviesUseCase
import com.example.movietvtracker.movies.presentation.mapper.MovieDomainToDisplayModelMapper
import com.example.movietvtracker.movies.presentation.mapper.MovieDomainToDisplayModelMapperImpl
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
    fun provideMovieDomainMapper(): MovieRemoteToDomainMapper {
        return MovieRemoteToDomainMapperImpl()
    }

    @Provides
    @Singleton
    fun provideMovieDisplayMapper(): MovieDomainToDisplayModelMapper {
        return MovieDomainToDisplayModelMapperImpl()
    }

    @Provides
    @Singleton
    fun provideGetMovies(
        moviesRepository: MoviesRepository,
        movieMapper: MovieRemoteToDomainMapper
    ): GetMoviesUseCase {
        return GetMoviesUseCase(
            moviesRepository = moviesRepository,
            movieMapper = movieMapper

        )
    }

}