package com.task.shared.di

import com.task.shared.core.dispatcher.CoroutineDispatchersProvider
import com.task.shared.core.dispatcher.DispatchersProvider
import com.task.shared.feature.detail.data.MovieDetailRepository
import com.task.shared.feature.detail.data.MovieDetailRepositoryImpl
import com.task.shared.feature.mainpage.data.UpcomingRepository
import com.task.shared.feature.mainpage.data.UpcomingRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

 internal val internalDataModule = module {
     singleOf(::CoroutineDispatchersProvider) bind(DispatchersProvider::class)
     singleOf(::UpcomingRepositoryImpl) bind(UpcomingRepository::class)
     singleOf(::MovieDetailRepositoryImpl) bind(MovieDetailRepository::class)
}