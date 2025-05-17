package com.example.movietvtracker.series.data.network.model

import com.example.movietvtracker.series.domain.model.Series

data class NetworkSeriesResponse(val code: Int, val message: String, val series: List<NetworkSeriesItem>)
data class NetworkSeriesItem(
    val id: Int,
    val title: String,
    val description: String,
    val poster: String,
    val releaseDate: String
)

fun NetworkSeriesItem.toDomain(): Series = Series(
    id = id,
    title = title,
    description = description,
    poster = poster,
    releaseDate = releaseDate
)