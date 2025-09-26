package com.task.shared.platform.di

import com.task.shared.platform.enum.OsType
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformCoreModule: Module = module {
    single<OsType> { OsType.IOS }
}