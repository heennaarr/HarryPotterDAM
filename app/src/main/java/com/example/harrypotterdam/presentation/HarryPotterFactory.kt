package com.example.harrypotterdam.presentation

import android.content.Context
import com.example.harrypotterdam.data.HarryPotterDataRepository
import com.example.harrypotterdam.data.remote.HarryPotterApiDataSource
import com.example.harrypotterdam.domain.GetCharactersUseCase

class HarryPotterFactory(private val context: Context) {

    private val apiDataSource = HarryPotterApiDataSource()

    private val harryPotterDataRepository= HarryPotterDataRepository(apiDataSource)

    val getCharactersUseCase = GetCharactersUseCase(harryPotterDataRepository)

    fun getCharactersListViewModel() : HarryPotterViewModel {
        return HarryPotterViewModel(getCharactersUseCase)
    }

}
