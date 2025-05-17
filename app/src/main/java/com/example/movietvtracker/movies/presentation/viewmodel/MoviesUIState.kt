package com.example.movietvtracker.movies.presentation.viewmodel

import com.example.movietvtracker.movies.domain.model.MovieDisplayModel
import java.sql.Date
import java.sql.Time

sealed interface MoviesUIState {
    data object Loading : MoviesUIState
    data class Success(val movies: List<MovieDisplayModel> = emptyList()) : MoviesUIState
    data class Failure(val error: String) : MoviesUIState
}