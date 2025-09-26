package com.task.shared.di

import com.task.shared.feature.detail.domain.MovieDetailUseCase
import com.task.shared.feature.detail.domain.MovieDetailUseCaseImpl
import com.task.shared.feature.mainpage.domain.UpcomingUseCase
import com.task.shared.feature.mainpage.domain.UpcomingUseCaseImpl

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

 internal val internalUseCaseModule = module {
     singleOf(::UpcomingUseCaseImpl) bind(UpcomingUseCase::class)
     singleOf(::MovieDetailUseCaseImpl) bind(MovieDetailUseCase::class)
}