package com.make.deve.pruebacoink.ui.register

import com.make.deve.pruebacoink.di.BaseModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object RegisterModule : BaseModule() {
    override val modules: List<Module>
        get() = listOf(mod)

    private val mod = module {
        viewModel { RegisterViewModel() }
    }
}