package com.example.movietvtracker.movies.presentation.mapper

import com.example.movietvtracker.movies.domain.model.MovieDomainModel
import com.example.movietvtracker.movies.presentation.model.MovieDisplayModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MovieDomainToDisplayModelMapperImpl : MovieDomainToDisplayModelMapper {
    override fun mapMovie(domainMovies: List<MovieDomainModel>): List<MovieDisplayModel> {
        val mappedMovies =
            domainMovies.map {
                MovieDisplayModel(
                    id = it.id,
                    description = it.overview,
                    poster = it.poster,
                    releaseDate = parseDate(it.releaseDate),
                    title = it.title,
                )
            }
        return mappedMovies
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