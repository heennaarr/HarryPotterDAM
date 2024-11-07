package com.example.harrypotterdam.di

import com.example.harrypotterdam.data.remote.HarryPotterService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class HarryPotterModule {
    @Single
    fun provideHarryPotterService(retrofit: Retrofit)=
        retrofit.create(HarryPotterService::class.java)


}