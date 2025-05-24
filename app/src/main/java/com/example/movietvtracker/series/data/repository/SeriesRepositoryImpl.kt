package com.example.movietvtracker.series.data.repository

import com.example.movietvtracker.series.data.network.model.NetworkSeriesItem
import com.example.movietvtracker.series.data.network.model.toDomain
import com.example.movietvtracker.series.data.network.retrofit.SeriesNetworkSource
import com.example.movietvtracker.series.domain.model.Series
import com.example.movietvtracker.series.domain.repository.SeriesRepository
import javax.inject.Inject

internal class SeriesRepositoryImpl @Inject constructor(private val networkSource: SeriesNetworkSource) :
    SeriesRepository {
    override suspend fun getSeries(): List<Series> {
        return networkSource.getSeries().series.map(NetworkSeriesItem::toDomain)
    }
}