package com.task.shared.mapper

import com.task.models.UiMovie
import com.task.response.MovieResponse

fun MovieResponse.toUiMove(): UiMovie {
    return UiMovie(
        id = id ?: 0,
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = posterPath.orEmpty(),
        voteAverage = voteAverage ?: 0.0,
    )
}

