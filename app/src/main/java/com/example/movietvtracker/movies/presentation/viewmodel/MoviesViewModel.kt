package com.example.movietvtracker.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietvtracker.movies.domain.usecase.GetMoviesUseCase
import com.example.movietvtracker.movies.presentation.mapper.MovieDomainToDisplayModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovies: GetMoviesUseCase,
    private val mapMovies: MovieDomainToDisplayModelMapper,
) : ViewModel() {

    private val _moviesState = MutableStateFlow<MoviesUIState>(MoviesUIState.Loading)
    val moviesState: StateFlow<MoviesUIState> get() = _moviesState.asStateFlow()


    fun execute() {
        viewModelScope.launch {
            try {
                _moviesState.value = MoviesUIState.Loading
                val movies = getMovies.execute()
                val mappedMovies = mapMovies.mapMovie(movies)
                _moviesState.value = MoviesUIState.Success(mappedMovies)
            } catch (e: Exception) {
                _moviesState.value = MoviesUIState.Failure(error = e.toString())
            }
        }
    }

}