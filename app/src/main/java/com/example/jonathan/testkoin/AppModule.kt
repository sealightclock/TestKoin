package com.example.jonathan.testkoin

import android.util.Log
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * This is the Koin module for the application.
 */
private const val TAG = "TK: AppModule"

// Repository Interface
interface Repository {
    fun fetchData(viewModelName: String): String
}

// A 1st Repository
class FirstRepository : Repository {
    override fun fetchData(viewModelName: String): String {
        Log.d(TAG, "FirstRepository: fetchData: viewModelName=[$viewModelName]")

        return "Hello from Koin FirstRepository and viewModelName=[$viewModelName]!"
    }
}

// A 2nd Repository
class SecondRepository : Repository {
    override fun fetchData(viewModelName: String): String {
        Log.d(TAG, "SecondRepository: fetchData: viewModelName=[$viewModelName]")

        return "Hello from Koin SecondRepository and viewModelName=[$viewModelName]!"
    }
}

// A 1st ViewModel
class FirstViewModel(private val repository: FirstRepository) : ViewModel() {
    fun getData(): String {
        Log.d(TAG, "FirstViewModel: getData")

        return repository.fetchData("FirstViewModel")
    }
}

// A 2nd ViewModel
class SecondViewModel(private val repository: SecondRepository) : ViewModel() {
    fun getData(): String {
        Log.d(TAG, "SecondViewModel: getData")

        return repository.fetchData("SecondViewModel")
    }
}

// Koin module to provide dependencies
val appModule = module {
    // Declare a singleton for Repository
    single { FirstRepository() }
    single { SecondRepository() }

    // Declare an object or factory for ViewModel
    viewModel { FirstViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}
