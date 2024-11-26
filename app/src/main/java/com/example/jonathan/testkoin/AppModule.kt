package com.example.jonathan.testkoin

import android.util.Log
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
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
class FirstViewModel(private val repository: Repository) : ViewModel() {
    fun getData(): String {
        Log.d(TAG, "FirstViewModel: getData")

        return repository.fetchData("FirstViewModel")
    }
}

// A 2nd ViewModel
class SecondViewModel(private val repository: Repository) : ViewModel() {
    fun getData(): String {
        Log.d(TAG, "SecondViewModel: getData")

        return repository.fetchData("SecondViewModel")
    }
}

// Koin Module for Repositories
val repositoryModule = module {
    Log.d(TAG, "repositoryModule")

    // Declare a singleton for each Repository
    single<Repository>(named("FirstRepository")) { FirstRepository() }
    single<Repository>(named("SecondRepository")) { SecondRepository() }
}

// Koin Module for ViewModels
val viewModelModule = module {
    Log.d(TAG, "viewModelModule")

    // TODO: Find a better way to match ViewModels with Repositories:
    viewModel(named("FirstViewModel")) { FirstViewModel(get(named("SecondRepository"))) }
    viewModel(named("SecondViewModel")) { SecondViewModel(get(named("FirstRepository"))) }
}
