package com.task.network.ktor.datasource

import com.task.response.MovieDetailsResponse
import com.task.response.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface NetflixDatasource {
    fun getUpcomingMovies(): Flow<MoviesResponse>
    fun moviesDetail(moveId: Int): Flow<MovieDetailsResponse>
}