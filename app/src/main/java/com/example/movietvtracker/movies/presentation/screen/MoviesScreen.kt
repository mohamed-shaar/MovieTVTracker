package com.example.movietvtracker.movies.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel import com.example.movietvtracker.movies.domain.model.MovieDisplayModel
import com.example.movietvtracker.movies.presentation.viewmodel.MoviesUIState
import com.example.movietvtracker.movies.presentation.viewmodel.MoviesViewModel
@Composable
fun MoviesScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val uiState by viewModel.moviesState.collectAsState()

    when (uiState) {
        is MoviesUIState.Loading -> Unit // TODO: To be implementeed
        is MoviesUIState.Failure -> Unit // TODO: To be implementeed
        is MoviesUIState.Success -> MoviesScreen((uiState as MoviesUIState.Success).movies)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(movies: List<MovieDisplayModel>) {
    Scaffold (
        topBar = {
            TopAppBar(title = { Text("Movies") })
        }
    ) { paddingValues ->
        MoviesList(
            movies = movies,
            modifier = Modifier.padding(paddingValues),
            onItemClick = { /* Handle movie item click here */ }
        )
    }
}

@Composable
fun MoviesList(
    movies: List<MovieDisplayModel>,
    modifier: Modifier = Modifier,
    onItemClick: (MovieDisplayModel) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(movies) { movie ->
            MovieListItem(movie = movie, onClick = { onItemClick(movie) })
        }
    }
}

@Composable
fun MovieListItem(movie: MovieDisplayModel, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.alignByBaseline()
        )
    }
}