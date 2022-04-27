package com.make.deve.pruebacoink.repo.info

import com.make.deve.pruebacoink.di.BaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

object InfoRepoModule: BaseModule() {
    private val mod = module { single<IInfoRepo> { InfoRepo(get()) } }
    override val modules: List<Module>
        get() = listOf(mod)
}