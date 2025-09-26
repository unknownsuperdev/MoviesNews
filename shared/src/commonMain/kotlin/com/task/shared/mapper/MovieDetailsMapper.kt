package com.task.shared.mapper

import com.task.models.UiMovieDetails
import com.task.response.MovieDetailsResponse

fun MovieDetailsResponse.toUiMovieDetails(): UiMovieDetails {
    return UiMovieDetails(
        adult = this.adult,
        backdropPath = this.backdropPath,
        homepage = this.homepage,
        id = this.id,
        imdbId = this.imdbId,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        runtime = this.runtime,
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}