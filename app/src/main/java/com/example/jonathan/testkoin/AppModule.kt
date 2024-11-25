package com.example.jonathan.testkoin

import org.koin.dsl.module

class Repository {
    fun fetchData(): String = "Hello from Koin Repository!"
}

class MyViewModel(private val repository: Repository) {
    fun getData(): String = repository.fetchData()
}

val appModule = module {
    single { Repository() }
    factory { MyViewModel(get()) }
}
