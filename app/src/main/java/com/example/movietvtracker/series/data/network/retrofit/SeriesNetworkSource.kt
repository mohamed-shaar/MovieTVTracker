package com.example.movietvtracker.series.data.network.retrofit

import com.example.movietvtracker.series.data.network.model.NetworkSeriesResponse

interface SeriesNetworkSource {
    suspend fun getSeries(): NetworkSeriesResponse
}