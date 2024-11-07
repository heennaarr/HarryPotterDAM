package com.example.harrypotterdam.feature.harry_potter.di

import com.example.harrypotterdam.feature.harry_potter.data.remote.HarryPotterService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class HarryPotterModule {
    @Single
    fun provideHarryPotterService(retrofit: Retrofit): HarryPotterService =
        retrofit.create(HarryPotterService::class.java)


}