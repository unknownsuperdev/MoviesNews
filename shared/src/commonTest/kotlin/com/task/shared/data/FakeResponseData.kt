package com.task.shared.data

import com.task.response.MovieDetailsResponse
import com.task.response.MovieResponse
import com.task.response.MoviesResponse

object FakeResponseData {

    fun createMovieResponse(): MoviesResponse {
        return MoviesResponse(
            listOf(
                MovieResponse(
                    1038392,
                    "The Conjuring: Last Rites",
                    "Paranormal investigators Ed and Lorraine Warren take on one last terrifying case involving mysterious entities they must confront.",
                    "/7JzOmJ1fIU43I3gLHYsY8UzNzjG.jpg",
                    "The Conjuring: Last Rites",
                    6.581
                )
            ),
            15,
            400
        )
    }

    fun createMovieDetailResponse(): MovieDetailsResponse {
        return MovieDetailsResponse(
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
    }
}