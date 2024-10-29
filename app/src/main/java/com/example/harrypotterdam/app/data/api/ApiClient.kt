package com.example.harrypotterdam.app.data.api

import com.example.harrypotterdam.data.remote.HarryPotterService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL_API = "https://hp-api.onrender.com/api/"
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun provideHarryPotterApi(retrofit: Retrofit): HarryPotterService {
        return retrofit.create(HarryPotterService::class.java)
    }


}