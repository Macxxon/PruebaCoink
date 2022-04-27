package com.make.deve.pruebacoink

import android.app.Application
import com.facebook.stetho.Stetho
import com.make.deve.pruebacoink.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        Stetho.initializeWithDefaults(this)

        startKoin {
            // use AndroidLogger as Koin Logger - default Level.INFO
            androidLogger()

            // use the Android context given there
            androidContext(this@App)

            // load properties from assets/koin.properties file
            androidFileProperties()

            // module list
            modules(
                Modules.getAllModules()
            )
        }

    }

    companion object {
        lateinit var instance: App private set
    }
}