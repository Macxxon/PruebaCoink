package com.make.deve.pruebacoink.remote.util

import com.make.deve.pruebacoink.di.BaseModule
import com.make.deve.pruebacoink.remote.errorManager.IRemoteErrorManager
import com.make.deve.pruebacoink.remote.errorManager.RemoteErrorManager
import org.koin.core.module.Module
import org.koin.dsl.module

object RemoteModule : BaseModule() {

    override val modules: List<Module>
        get() = listOf(module)

    private val module = module {
        single<IRemoteErrorManager> { RemoteErrorManager() }
    }
}