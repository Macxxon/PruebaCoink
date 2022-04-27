package com.make.deve.pruebacoink.repo.util

import com.make.deve.pruebacoink.di.BaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

object RepoModule : BaseModule() {

    override val modules: List<Module>
        get() = listOf(module)

    private val module = module {
        single<IErrorMapper> { ErrorMapper() }
    }
}