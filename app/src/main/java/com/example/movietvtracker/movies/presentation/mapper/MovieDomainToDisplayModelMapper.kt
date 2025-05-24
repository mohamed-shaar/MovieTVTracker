package com.example.movietvtracker.movies.presentation.mapper

import com.example.movietvtracker.movies.domain.model.MovieDomainModel
import com.example.movietvtracker.movies.presentation.model.MovieDisplayModel

interface MovieDomainToDisplayModelMapper {
    fun mapMovie(domainMovies: List<MovieDomainModel>): List<MovieDisplayModel>
}