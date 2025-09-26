package com.task.models

data class UiMovie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
) {
    val posterUrl = "https://image.tmdb.org/t/p/w185" + posterPath

    val rating = voteAverage.toString()
}
