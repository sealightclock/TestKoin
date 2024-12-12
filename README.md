# TestKoin

[1] Configure Koin.
./gradle/libs.versions.toml:
[versions]
koin = "3.5.0"
koin-android = { module = "io.insert-koin:koin-android", version.ref = "koin" }
koin-compose = { module = "io.insert-koin:koin-androidx-compose", version.ref = "koin" }
./app/build.gradle.kts:
implementation(libs.koin.android)
implementation(libs.koin.compose)

[2] AppModule.kt
2 Repository classes
2 ViewModel classes
repositoryModule
viewModelModule

[3] MyApplication.kt
startKoin {
    modules(listOf(repositoryModule, viewModelModule))
}

[4] MyView.kt (fun MainScreen):
val firstViewModel: FirstViewModel = koinViewModel(named("FirstViewModel"))
val secondViewModel: SecondViewModel = koinViewModel(named("SecondViewModel"))

[5] MainActivity.kt:
Simply:
setContent {
    MainScreen()
}
