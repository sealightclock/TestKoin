package com.example.jonathan.testkoin

import android.util.Log
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * This is the Koin module for the application.
 */
private const val TAG = "TK: AppModule"

// A 1st Repository
class MyRepository {
    fun fetchData(): String {
        Log.d(TAG, "MyRepository: fetchData")

        return "Hello from Koin MyRepository!"
    }
}

// A 1st ViewModel
class FirstViewModel(private val myRepository: MyRepository) : ViewModel() {
    fun getData(): String {
        Log.d(TAG, "FirstViewModel: getData")

        return myRepository.fetchData()
    }
}

// A 2nd ViewModel
class SecondViewModel(private val myRepository: MyRepository) : ViewModel() {
    fun getData(): String {
        Log.d(TAG, "SecondViewModel: getData")

        return myRepository.fetchData()
    }
}

// Koin module to provide dependencies
val appModule = module {
    // Declare a singleton for Repository
    single { MyRepository() }

    // Declare an object or factory for ViewModel
    viewModel { FirstViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}
