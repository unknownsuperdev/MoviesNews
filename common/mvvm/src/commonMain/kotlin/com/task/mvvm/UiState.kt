package com.task.mvvm

import androidx.compose.runtime.Immutable

@Immutable
interface UiState {
    val error: String?
}