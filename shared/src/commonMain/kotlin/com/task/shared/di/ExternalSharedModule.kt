package com.task.shared.di

import com.task.network.di.networkModule
import com.task.shared.platform.di.platformCoreModule
import org.koin.core.module.Module
import org.koin.dsl.module


val externalSharedModule: Module
    get() = module {
        includes(
            internalDataModule  +
                    internalUseCaseModule +
                    platformCoreModule +
                    viewModelModule +
                    networkModule
        )
    }