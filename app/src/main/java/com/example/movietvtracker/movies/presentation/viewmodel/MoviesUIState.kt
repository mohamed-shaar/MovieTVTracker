package com.example.movietvtracker.movies.presentation.viewmodel

import com.example.movietvtracker.movies.presentation.model.MovieDisplayModel

sealed interface MoviesUIState {
    data object Loading : MoviesUIState
    data class Success(val movies: List<MovieDisplayModel>) : MoviesUIState
    data class Failure(val error: String) : MoviesUIState
}