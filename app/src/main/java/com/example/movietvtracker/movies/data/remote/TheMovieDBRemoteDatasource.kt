package com.example.movietvtracker.movies.data.remote

import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class TheMovieDBRemoteDatasource: MoviesRemoteDataSource {
    override suspend fun execute(): List<MovieRemoteModel> {
        delay(3000)
        val mockMovies = listOf(
            MovieRemoteModel(
                id = 1001,
                overview = "A brilliant mathematician struggles with schizophrenia while making groundbreaking discoveries in the field of game theory.",
                poster = "https://example.com/posters/beautiful_mind.jpg",
                releaseDate = "2001-12-21",
                title = "A Beautiful Mind"
            ),
            MovieRemoteModel(
                id = 2052,
                overview = "A group of astronauts journey through a wormhole in search of a new habitable planet as Earth's resources are depleted.",
                poster = "https://example.com/posters/interstellar.jpg",
                releaseDate = "2014-11-07",
                title = "Interstellar"
            ),
            MovieRemoteModel(
                id = 3784,
                overview = "The aging patriarch of an organized crime dynasty transfers control to his reluctant son.",
                poster = null,
                releaseDate = "1972-03-24",
                title = "The Godfather"
            ),
            MovieRemoteModel(
                id = 4237,
                overview = "A thief who steals corporate secrets through dream-sharing technology is given the task of planting an idea into the mind of a CEO.",
                poster = "https://example.com/posters/inception.jpg",
                releaseDate = "2010-07-16",
                title = "Inception"
            ),
            MovieRemoteModel(
                id = 5673,
                overview = "A teenager with telekinetic powers lashes out with devastating consequences after being humiliated at her high school prom.",
                poster = "https://example.com/posters/carrie.jpg",
                releaseDate = "1976-11-03",
                title = "Carrie"
            )
        )
        return mockMovies
    }
}