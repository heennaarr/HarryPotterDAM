package com.example.harrypotterdam.app.di

import com.google.gson.Gson
import org.koin.core.annotation.Module
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.example.harrypotterdam")
class AppModule {
    @Single
    fun provideGson() = Gson()
   
}