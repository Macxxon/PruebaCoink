package com.make.deve.pruebacoink.ui.main

import com.make.deve.pruebacoink.di.BaseModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule  : BaseModule() {
    override val modules: List<Module>
        get() = listOf(mod)

    private val mod = module {
        viewModel { MainViewModel() }
    }
}