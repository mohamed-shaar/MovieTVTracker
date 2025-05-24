package com.example.movietvtracker.series.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietvtracker.series.domain.model.Series
import com.example.movietvtracker.series.domain.usecase.GetSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SeriesViewModel @Inject constructor(val getSeriesUseCase : GetSeriesUseCase):ViewModel() {
    private val _seriesUiState = MutableStateFlow<SeriesUiState>(SeriesUiState.Loading)
    val seriesUiState: StateFlow<SeriesUiState> = _seriesUiState

    init {
        fetchSeries()
    }

    private fun fetchSeries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val series = getSeriesUseCase()
                val uiModels = series.map(Series::toUiModel)
                Log.d("TAG", "fetchSeries: $uiModels")
                _seriesUiState.value = SeriesUiState.Success(uiModels)
            } catch (e: Exception) {
                _seriesUiState.value = SeriesUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}