package com.make.deve.pruebacoink.di

import org.koin.core.module.Module

abstract class BaseModule {
    abstract val modules: List<Module>
}