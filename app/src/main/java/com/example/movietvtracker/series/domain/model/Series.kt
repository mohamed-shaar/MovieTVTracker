package com.example.movietvtracker.series.domain.model

import com.example.movietvtracker.series.presentation.SeriesUiState
import com.example.movietvtracker.series.presentation.UiSeries

data class Series(
    val id: Int,
    val title: String,
    val description: String,
    val poster: String,
    val releaseDate: String
)

fun Series.toUiModel(): UiSeries =
    UiSeries(id = id, title = title, thumb = poster, releaseDate = releaseDate)