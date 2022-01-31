package com.lucasmarciano.composeproject

import android.app.Application
import com.lucasmarciano.composeproject.di.modules.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BaseAppApplication)
            modules(
                featureModule
            )
        }
    }
}
