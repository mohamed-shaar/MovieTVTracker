package com.example.movietvtracker.series.di

import com.example.movietvtracker.series.data.repository.SeriesRepositoryImpl
import com.example.movietvtracker.series.domain.repository.SeriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface SeriesRepositoryModule {

@Binds
fun bindsSeriesRepository(seriesRepositoryImpl: SeriesRepositoryImpl): SeriesRepository
}