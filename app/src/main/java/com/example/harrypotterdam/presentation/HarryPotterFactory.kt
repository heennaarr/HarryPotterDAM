package com.example.harrypotterdam.presentation

import android.content.Context
import com.example.harrypotterdam.app.data.api.ApiClient
import com.example.harrypotterdam.data.HarryPotterDataRepository
import com.example.harrypotterdam.data.remote.HarryPotterApiDataSource
import com.example.harrypotterdam.domain.GetCharacterSelectedUseCase
import com.example.harrypotterdam.domain.GetCharactersUseCase

class HarryPotterFactory(private val context: Context) {


    private val harryPotterDataRepository= HarryPotterDataRepository(
        getHarryPotterApiRemoteDataSource()
    )

     val getCharactersUseCase = GetCharactersUseCase(harryPotterDataRepository)
    val getCharacterSelectedUseCase = GetCharacterSelectedUseCase(harryPotterDataRepository)

    fun getCharactersListViewModel() : HarryPotterViewModel {
        return HarryPotterViewModel(getCharactersUseCase)
    }
    fun getCharacterDetailViewModel() : HarryPotterCharactersDetailViewModel {
        return HarryPotterCharactersDetailViewModel(getCharacterSelectedUseCase)
    }
    private fun getHarryPotterApiRemoteDataSource(): HarryPotterApiDataSource {
        val harryPotterService = ApiClient.provideHarryPotterApi(ApiClient.provideRetrofit())
        return HarryPotterApiDataSource(harryPotterService)
    }

}
