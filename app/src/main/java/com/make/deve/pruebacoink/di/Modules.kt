package com.make.deve.pruebacoink.di

import com.make.deve.pruebacoink.remote.info.InfoServiceModule
import com.make.deve.pruebacoink.remote.util.RemoteModule
import com.make.deve.pruebacoink.repo.info.InfoRepoModule
import com.make.deve.pruebacoink.repo.util.RepoModule
import com.make.deve.pruebacoink.ui.main.MainModule
import com.make.deve.pruebacoink.ui.register.RegisterModule
import org.koin.core.module.Module

object Modules {
    fun getAllModules(): List<Module> {
        val allModules = ArrayList<Module>()

        //region Bases
        allModules.addAll(RemoteModule)
        allModules.addAll(RepoModule)
        //endregion

        //region Service Modules
        allModules.addAll(InfoServiceModule)
        //endregion

        //region Repo Modules
        allModules.addAll(InfoRepoModule)
        //endregion

        //region UI Modules
        allModules.addAll(MainModule)
        allModules.addAll(RegisterModule)
        //endregion

        return allModules
    }
}

fun ArrayList<Module>.addAll(mod: BaseModule) {
    addAll(mod.modules)
}