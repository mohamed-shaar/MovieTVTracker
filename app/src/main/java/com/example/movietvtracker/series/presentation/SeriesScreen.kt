package com.example.movietvtracker.series.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SeriesScreen(viewModel: SeriesViewModel = hiltViewModel()){
    val uiState by viewModel.seriesUiState.collectAsState()
    when(uiState){
        is SeriesUiState.Loading -> Unit // TODO: to be implemented
        is SeriesUiState.Error -> Unit //todo to be implemented
        is SeriesUiState.Success -> SeriesScreen((uiState as SeriesUiState.Success).series)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeriesScreen(seriesUiModels: List<UiSeries>) {
    Scaffold (
        topBar = {
            TopAppBar(title = { Text("Series") })
        }
    ) { paddingValues ->
        SeriesList(
            series = seriesUiModels,
            modifier = Modifier.padding(paddingValues),
            onItemClick = { selectedItem ->
                // Handle click (e.g., navigate or show details)
            }
        )
    }
}

@Composable
fun SeriesList(modifier: Modifier = Modifier,
    series: List<UiSeries>,
    onItemClick: (UiSeries) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(series) { item ->
            SeriesListItem(uiSeries = item, onClick = { onItemClick(item) })
        }
    }
}

@Composable
fun SeriesListItem(uiSeries: UiSeries, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp)
    ) {

        Text(
            text = uiSeries.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.alignByBaseline()
        )
    }
}