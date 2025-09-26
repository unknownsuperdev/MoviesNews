package com.task.shared.feature.mainpage.data

import com.task.models.UiMovie
import kotlinx.coroutines.flow.Flow

interface UpcomingRepository {
    fun upcoming(): Flow<List<UiMovie>>
}