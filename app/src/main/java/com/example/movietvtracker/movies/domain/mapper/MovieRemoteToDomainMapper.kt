package com.example.movietvtracker.movies.domain.mapper

import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel
import com.example.movietvtracker.movies.domain.model.MovieDomainModel

interface MovieRemoteToDomainMapper {
    operator fun invoke(remoteMovie: MovieRemoteModel): MovieDomainModel
}