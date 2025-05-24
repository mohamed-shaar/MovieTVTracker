package com.example.movietvtracker.series.domain.repository

import com.example.movietvtracker.series.domain.model.Series

interface SeriesRepository {
    suspend fun getSeries(): List<Series>

}