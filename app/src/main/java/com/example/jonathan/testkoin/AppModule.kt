package com.example.jonathan.testkoin

import android.util.Log
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val TAG = "TK: AppModule"

class Repository {
    fun fetchData(): String {
        Log.d(TAG, "Repository: fetchData")

        return "Hello from Koin Repository!"
    }
}

class MyViewModel(private val repository: Repository) : ViewModel() {
    fun getData(): String = repository.fetchData()
}

val appModule = module {
    // Provide Repository
    single { Repository() }

    // Provide ViewModel
    viewModel { MyViewModel(get()) }
}
