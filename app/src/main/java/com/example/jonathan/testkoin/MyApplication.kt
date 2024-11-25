package com.example.jonathan.testkoin

import android.app.Application
import android.util.Log
import org.koin.core.context.startKoin

private const val TAG = "TK: MyApplication"

class MyApplication : Application() {
    override fun onCreate() {
        Log.d(TAG, "onCreate")

        super.onCreate()

        // Start Koin
        startKoin {
            modules(appModule)
        }
    }
}
