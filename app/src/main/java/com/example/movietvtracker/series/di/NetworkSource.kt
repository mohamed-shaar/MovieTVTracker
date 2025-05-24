package com.example.movietvtracker.series.di

import com.example.movietvtracker.series.data.network.model.NetworkSeriesItem
import com.example.movietvtracker.series.data.network.model.NetworkSeriesResponse
import com.example.movietvtracker.series.data.network.retrofit.SeriesNetworkSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.delay
import javax.inject.Singleton
import kotlin.random.Random

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkSource {
    @Singleton
    @Provides
    fun provideSeriesNetworkSource():SeriesNetworkSource{
        return SeriesNetworkSourceImpl()

    }
}

// Mocking the data source
private class SeriesNetworkSourceImpl:SeriesNetworkSource{
    override suspend fun getSeries(): NetworkSeriesResponse {
        delay(Random.nextLong(100,200))
        val mockSeriesList = listOf(
            NetworkSeriesItem(
                id = 1,
                title = "The Great Escape",
                description = "A thrilling adventure of prisoners breaking out during WWII.",
                poster = "https://example.com/posters/escape.jpg",
                releaseDate = "1963-07-04"
            ),
            NetworkSeriesItem(
                id = 2,
                title = "Future Unknown",
                description = "A sci-fi series exploring parallel dimensions and time travel.",
                poster = "https://example.com/posters/future.jpg",
                releaseDate = "2022-09-12"
            ),
            NetworkSeriesItem(
                id = 3,
                title = "Cairo Nights",
                description = "A dramatic tale set in the vibrant streets of Cairo.",
                poster = "https://example.com/posters/cairo.jpg",
                releaseDate = "2024-03-01"
            )
        )

        val mockNetworkSeriesResponse = NetworkSeriesResponse(
            code = 200,
            message = "Success",
            series = mockSeriesList
        )

    return mockNetworkSeriesResponse
    }

}