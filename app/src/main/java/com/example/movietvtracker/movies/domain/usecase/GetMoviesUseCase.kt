package com.example.movietvtracker.movies.domain.usecase

import com.example.movietvtracker.movies.presentation.model.MovieDisplayModel
import com.example.movietvtracker.movies.domain.repository.MoviesRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
) {
    suspend fun execute(): List<MovieDisplayModel> {
        val remoteMovies = moviesRepository.getMovies()
        val movies = remoteMovies.map {
            MovieDisplayModel(
                id = it.id,
                description = it.overview,
                poster = it.poster.toString(),
                releaseDate = parseDate(it.releaseDate),
                title = it.title,
            )
        }
        return movies
    }

    private fun parseDate(dateString: String): Date? {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
        try {
            val date: Date? = formatter.parse(dateString)
            println("Parsed date: $date")
            return date
        } catch (e: Exception) {
            println("Error: The date string '$dateString' is not in the expected format 'yyyy-MM-dd'.")
            return null // Return null or handle the error as needed
        }
    }
}