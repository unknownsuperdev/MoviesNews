package com.task.shared.feature.detail.domain

import com.task.models.UiMovieDetails
import com.task.shared.core.dispatcher.DispatchersProvider
import com.task.shared.feature.detail.data.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

interface MovieDetailUseCase {
    operator fun invoke(id: Int): Flow<UiMovieDetails>
}

internal class  MovieDetailUseCaseImpl(
    private val repository: MovieDetailRepository,
    private val dispatcher: DispatchersProvider
) : MovieDetailUseCase {

    override operator fun invoke(id: Int): Flow<UiMovieDetails> {
        return repository.moviesDetail(id).flowOn(dispatcher.io)
    }
}