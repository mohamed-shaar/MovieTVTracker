package com.example.movietvtracker.movies.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movietvtracker.movies.presentation.viewmodel.MoviesUIState
import com.example.movietvtracker.movies.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(
    moviesViewModel: MoviesViewModel,
    innerPadding: PaddingValues,
) {
    val moviesState by moviesViewModel.moviesState.collectAsStateWithLifecycle()

    when (moviesState) {
        MoviesUIState.Loading ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }

        is MoviesUIState.Failure -> Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "An unexpected error happened ${(moviesState as MoviesUIState.Failure).error}. Please try again.",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        is MoviesUIState.Success -> LazyColumn(
            contentPadding = innerPadding,
        ) {
            items((moviesState as MoviesUIState.Success).movies) {
                Column {
                    Text(it.title)
                    Text(it.description)
                }
            }
        }
    }
}