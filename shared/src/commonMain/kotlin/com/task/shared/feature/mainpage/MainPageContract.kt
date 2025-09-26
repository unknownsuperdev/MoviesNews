package com.task.shared.feature.mainpage

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.task.models.UiMovie
import com.task.mvvm.UiEffect
import com.task.mvvm.UiState

@Stable
sealed class MainPageEffect : UiEffect

@Immutable
data class MainPageState(
    override val error: String? = null,
    val loading: Boolean = false,
    val data:  List<UiMovie>? = null,
) : UiState