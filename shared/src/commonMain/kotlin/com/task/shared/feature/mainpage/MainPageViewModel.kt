package com.task.shared.feature.mainpage

import androidx.lifecycle.viewModelScope
import com.task.mvvm.BaseViewModel
import com.task.shared.feature.mainpage.domain.UpcomingUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MainPageViewModel :
    BaseViewModel<MainPageState, MainPageEffect>(MainPageState()), KoinComponent{

    private val getUpcomingMovie: UpcomingUseCase by inject()

    init {
        getUpcomingData()
    }

    fun getUpcomingData() {
        getUpcomingMovie().onStart {
            updateState {
                copy(
                    loading = true
                )
            }
        }.onEach {
            updateState {
                copy(
                    loading = false,
                    data = it
                )
            }
        }.catch {
            updateState { copy(error = it.message) }
        }.launchIn(viewModelScope)
    }
}