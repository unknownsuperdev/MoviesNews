package com.task.shared.feature.mainpage.data

import com.task.models.UiMovie
import com.task.network.ktor.datasource.NetflixDatasource
import com.task.shared.mapper.toUiMove
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UpcomingRepositoryImpl(
    private val netflixDatasource: NetflixDatasource
) : UpcomingRepository {

    override fun upcoming(): Flow<List<UiMovie>> =
        netflixDatasource.getUpcomingMovies().map {
           it.results?.map { it.toUiMove() }?: emptyList()
        }

}