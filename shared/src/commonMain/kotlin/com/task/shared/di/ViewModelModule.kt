package com.task.shared.di

import com.task.shared.feature.mainpage.MainPageViewModel
import com.task.shared.feature.detail.MovieDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModelOf(::MainPageViewModel)
    viewModelOf(::MovieDetailViewModel)
}