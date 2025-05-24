package com.example.movietvtracker.series.domain.usecase

import com.example.movietvtracker.series.domain.model.Series
import com.example.movietvtracker.series.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesUseCase @Inject constructor(private val seriesRepo:SeriesRepository) {
 suspend operator fun invoke(): List<Series> {
  return seriesRepo.getSeries()
 }
}