package com.task.shared.feature.mainpage.domain

import com.task.models.UiMovie
import com.task.shared.core.dispatcher.DispatchersProvider
import com.task.shared.feature.mainpage.data.UpcomingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

interface UpcomingUseCase {
    operator fun invoke(): Flow<List<UiMovie>>
}

internal class UpcomingUseCaseImpl(
    private val locationPagingRepository: UpcomingRepository,
    private val dispatcher: DispatchersProvider
) : UpcomingUseCase {

    override operator fun invoke(): Flow<List<UiMovie>>{
        return locationPagingRepository.upcoming().flowOn(dispatcher.io)
    }
}