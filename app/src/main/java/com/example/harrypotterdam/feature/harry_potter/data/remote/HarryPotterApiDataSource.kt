package com.example.harrypotterdam.feature.harry_potter.data.remote

import com.example.harrypotterdam.app.di.RemoteModule
import com.example.harrypotterdam.feature.harry_potter.di.HarryPotterModule
import com.example.harrypotterdam.feature.harry_potter.domain.Characters
import org.koin.core.annotation.Single

@Single
class HarryPotterApiDataSource {

    private val harryPotterModule = HarryPotterModule()
    private val remoteModule = RemoteModule()
   suspend fun buildClient(): List<Characters> {

       val loggingInterceptor = remoteModule.provideLogginInterceptor()
       val okHttpClient = remoteModule.provideOkHttpClient(loggingInterceptor)
       val retrofit = remoteModule.provideRetrofit(okHttpClient)

       val harry = harryPotterModule.provideHarryPotterService(retrofit).requestCharacters()
       if (harry.body()?.isNotEmpty()!!) {
           return harry.body()!!.map {
               it.toModel()
           }
       } else {
           return emptyList()
       }
   }
   }



