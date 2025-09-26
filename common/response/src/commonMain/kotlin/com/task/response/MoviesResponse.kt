package com.task.response
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("results")
    val results: List<MovieResponse>?,
    @SerialName("total_pages")
    val totalPages: Int?,
    @SerialName("total_results")
    val totalResults: Int?
)
@Serializable
data class MovieResponse(
    @SerialName("id")
    val id: Int?,
    @SerialName("original_title")
    val originalTitle: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("vote_average")
    val voteAverage: Double?
)