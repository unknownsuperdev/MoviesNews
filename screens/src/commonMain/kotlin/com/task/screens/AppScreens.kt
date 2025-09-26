package com.task.screens

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
@Serializable
sealed class AppScreens : Screens() {

    @Stable
    @Serializable
    data object Home : AppScreens()

    @Stable
    @Serializable
    data class MoviesDetail(val id: Int) : AppScreens()
}
