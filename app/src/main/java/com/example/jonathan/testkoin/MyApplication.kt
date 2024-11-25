package com.example.jonathan.testkoin

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            modules(appModule)
        }
    }
}
