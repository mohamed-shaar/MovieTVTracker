package com.example.movietvtracker.series.presentation

import com.example.movietvtracker.series.domain.model.Series

sealed class SeriesUiState {
    data object Loading : SeriesUiState()
    data class Success(val series: List<UiSeries>) : SeriesUiState()
    data class Error(val message: String) : SeriesUiState()
}
data class UiSeries(val id:Int,val title:String,val thumb:String,val releaseDate:String)

fun Series.toUiModel(): UiSeries =
    UiSeries(id = id, title = title, thumb = poster, releaseDate = releaseDate)