package com.task.shared.feature.detail

import androidx.compose.runtime.Immutable
import com.task.models.UiMovieDetails
import com.task.mvvm.UiState

@Immutable
data class MovieDetailState(
    override val error: String? = null,
    val isLoading: Boolean = true,
    val detailItem:  UiMovieDetails? = null,
) : UiState