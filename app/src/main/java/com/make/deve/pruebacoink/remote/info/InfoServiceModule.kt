package com.make.deve.pruebacoink.remote.info

import com.make.deve.pruebacoink.di.BaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

object InfoServiceModule : BaseModule() {
    private val mod: Module = module {
        single<IInfoService> { InfoService() }
    }

    override val modules: List<Module>
        get() = listOf(mod)
}