package com.task.shared.feature.detail

import androidx.lifecycle.viewModelScope
import com.task.mvvm.BaseViewModel
import com.task.mvvm.UiEffect
import com.task.shared.feature.detail.domain.MovieDetailUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MovieDetailViewModel(val id: Int) :
    BaseViewModel<MovieDetailState, UiEffect>(MovieDetailState()), KoinComponent {

    private val movieDetailUseCase: MovieDetailUseCase by inject()

    init {
        fetchData()
    }

    private fun fetchData() {
        movieDetailUseCase(id)
            .onStart {
                updateState {
                    copy(
                        isLoading = true
                    )
                }
            }.onEach {
                updateState {
                    copy(
                        isLoading = false,
                        detailItem = it
                    )
                }
            }.catch {
                updateState {
                    copy(
                        error = it.message,
                    )
                }
            }.launchIn(viewModelScope)
    }
}