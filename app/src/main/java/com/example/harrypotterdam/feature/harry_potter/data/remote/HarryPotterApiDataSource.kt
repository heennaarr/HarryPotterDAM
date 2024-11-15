package com.example.harrypotterdam.feature.harry_potter.data.remote

import com.example.harrypotterdam.feature.harry_potter.domain.Characters
import org.koin.core.annotation.Single

@Single
class HarryPotterApiDataSource(private val harryPotterService: HarryPotterService) {

    suspend fun getCharacters(): List<Characters> {
        val response = harryPotterService.requestCharacters()
        if (response.isSuccessful) {
            return response.body()!!.map { mushrooms ->
                mushrooms.toModel()
            }
        } else {
            return emptyList()
        }


    }
   }



