package com.example.movietvtracker.movies.domain.mapper

import com.example.movietvtracker.movies.data.remote.model.MovieRemoteModel
import com.example.movietvtracker.movies.domain.model.MovieDomainModel

class MovieRemoteToDomainMapperImpl : MovieRemoteToDomainMapper {
    override fun invoke(remoteMovie: MovieRemoteModel): MovieDomainModel {
        return MovieDomainModel(
            id = remoteMovie.id,
            overview = remoteMovie.overview,
            poster = remoteMovie.poster ?: "",
            releaseDate = remoteMovie.releaseDate,
            title = remoteMovie.title,
        )
    }


}