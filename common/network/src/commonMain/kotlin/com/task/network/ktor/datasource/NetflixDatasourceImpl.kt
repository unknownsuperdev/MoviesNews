package com.task.network.ktor.datasource

import com.task.response.MovieDetailsResponse
import com.task.response.MoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class NetflixDatasourceImpl(private val httpClient: HttpClient) : NetflixDatasource {

    private val upcomingUrl = "movie/upcoming"
    private val moveDetail = "movie/"

    override fun getUpcomingMovies(): Flow<MoviesResponse> = flow {
        val body: MoviesResponse = httpClient.get(upcomingUrl) {
            contentType(ContentType.Application.Json)
        }.body()
        emit(body)
    }

    override fun moviesDetail(moveId: Int): Flow<MovieDetailsResponse> = flow {
        val body: MovieDetailsResponse = httpClient.get("$moveDetail$moveId") {
            contentType(ContentType.Application.Json)
        }.body()
        emit(body)
    }
}