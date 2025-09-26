package com.task.shared.data

import app.cash.turbine.test
import com.task.network.ktor.datasource.NetflixDatasource
import com.task.shared.feature.mainpage.data.UpcomingRepositoryImpl
import com.task.shared.mapper.toUiMove
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UpcomingRepositoryImplTest {

    @Test
    fun `upcoming should map MoviesResponse to UiMovie list`() = runTest {
        val moviesResponse = FakeResponseData.createMovieResponse()
        val movieDetailResponse = FakeResponseData.createMovieDetailResponse()
        val movieResponse = moviesResponse.results?.first()


        val fakeDatasource = object : NetflixDatasource {
            override fun getUpcomingMovies() = flowOf(moviesResponse)
            override fun moviesDetail(moveId: Int) = flowOf(movieDetailResponse)
        }

        val repository = UpcomingRepositoryImpl(fakeDatasource)
        val expectedUi = movieResponse?.toUiMove()

        repository.upcoming().test {
            val result = awaitItem()
            assertEquals(listOf(expectedUi), result)
            awaitComplete()
        }
    }
}