package com.task.shared.feature.detail.data

import com.task.models.UiMovieDetails
import com.task.network.ktor.datasource.NetflixDatasource
import com.task.shared.mapper.toUiMovieDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface MovieDetailRepository {
    fun moviesDetail(id: Int): Flow<UiMovieDetails>
}

internal class MovieDetailRepositoryImpl(private val dataSource: NetflixDatasource) :
    MovieDetailRepository {
    override fun moviesDetail(id: Int): Flow<UiMovieDetails> = dataSource.moviesDetail(id).map { it.toUiMovieDetails() }
}
