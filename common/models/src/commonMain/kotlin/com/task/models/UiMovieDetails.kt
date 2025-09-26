package com.task.models

data class UiMovieDetails(
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val homepage: String? = null,
    val id: Int,
    val imdbId: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val runtime: Int? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null
){

    val posterUrl = "https://image.tmdb.org/t/p/w185" + posterPath
    fun getRating(): String {
        val byTwo = voteAverage?.div(2)
        val before = byTwo.toString().substringBefore(".")
        val after = byTwo.toString().substringAfter(".").split("")[1]
        return "$before.$after"
    }

    fun getPopularity(): String {
        return ((voteAverage?.toInt()?.times(100))?.div(10)).toString()
    }

    fun getMovieDuration(): String? {
        return if (runtime != null) {
            val hours = (runtime / 60)
            val minutes = runtime % 60

            val runtime = if (hours <= 1) "${hours}hr ${minutes}mins" else "${hours}hrs ${minutes}mins"

            runtime
        } else {
            null
        }
    }
}