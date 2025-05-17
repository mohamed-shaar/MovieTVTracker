package com.example.movietvtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.movietvtracker.movies.presentation.screen.MoviesScreen
import com.example.movietvtracker.movies.presentation.viewmodel.MoviesViewModel
import com.example.movietvtracker.ui.theme.MovieTVTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieTVTrackerTheme {
                MainScreen()
            }
        }
    }
}
