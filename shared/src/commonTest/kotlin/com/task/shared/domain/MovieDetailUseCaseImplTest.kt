package com.task.shared.domain

import app.cash.turbine.test
import com.task.models.UiMovieDetails
import com.task.shared.core.dispatcher.DispatchersProvider
import com.task.shared.feature.detail.data.MovieDetailRepository
import com.task.shared.feature.detail.domain.MovieDetailUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MovieDetailUseCaseImplTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    private val dispatcherProvider = object : DispatchersProvider {
        override val io = testDispatcher
        override val main = testDispatcher
    }

    @Test
    fun `invoke should return movie details`() = runTest {
        // Arrange
        val movieId = 1
        val expectedDetails = UiMovieDetails(
            false,
            "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
            "http://www.theconjuringmovie.com",
            1038392,
            "tt22898462",
            "en",
            "The Conjuring: Last Rites",
            "Paranormal investigators Ed and Lorraine Warren take on one last terrifying case involving mysterious entities they must confront.",
            249.8959,
            "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
            "2025-09-03",
            135,
            "Released",
            "The case that ended it all.",
            "The Conjuring: Last Rites",
            false,
            6.6,
            429
        )

        val fakeRepository = object : MovieDetailRepository {
            override fun moviesDetail(id: Int) = flowOf(expectedDetails)
        }

        val useCase = MovieDetailUseCaseImpl(fakeRepository, dispatcherProvider)

        // Act + Assert
        useCase(movieId).test {
            val result = awaitItem()
            assertEquals(expectedDetails, result)
            awaitComplete()
        }
    }

    @Test
    fun `invoke should return different movie details based on id`() = runTest {
        val movie1 = UiMovieDetails(
                false,
                "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
                "http://www.theconjuringmovie.com",
                1038392,
                "tt22898462",
                "en",
                "The Conjuring: Last Rites",
                "Paranormal investigators Ed and Lorraine Warren take on one last terrifying case involving mysterious entities they must confront.",
                249.8959,
                "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
                "2025-09-03",
                135,
                "Released",
                "The case that ended it all.",
                "The Conjuring: Last Rites",
                false,
                6.6,
                429
            )

        val movie2 = UiMovieDetails(
                true,
                "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
                "http://www.theconjuringmovie.com",
                1038393,
                "tt22898462",
                "en",
                "The Conjuring: Last Rites",
                "Paranormal investigators Ed and Lorraine Warren take on one last terrifying case involving mysterious entities they must confront.",
                249.8959,
                "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
                "2025-09-03",
                135,
                "Released",
                "The case that ended it all.",
                "The Conjuring: Last Rites",
                false,
                6.6,
                429
            )

        val fakeRepository = object : MovieDetailRepository {
            override fun moviesDetail(id: Int) = flowOf(
                if (id == 1) movie1 else movie2
            )
        }

        val useCase = MovieDetailUseCaseImpl(fakeRepository, dispatcherProvider)

        // Act + Assert
        useCase(1).test {
            assertEquals(movie1, awaitItem())
            awaitComplete()
        }

        useCase(2).test {
            assertEquals(movie2, awaitItem())
            awaitComplete()
        }
    }
}
