package com.example.harrypotterdam.app

import android.app.Application
import com.example.harrypotterdam.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class HarryPotter: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HarryPotter)
            modules(AppModule().module)
        }
    }
}