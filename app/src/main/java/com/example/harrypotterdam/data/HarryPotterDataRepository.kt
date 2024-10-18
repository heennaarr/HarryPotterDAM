package com.example.harrypotterdam.data

import com.example.harrypotterdam.data.remote.HarryPotterApiDataSource
import com.example.harrypotterdam.domain.Characters
import com.example.harrypotterdam.domain.HarryPotterRepository

class HarryPotterDataRepository(
    private val apiDataSource: HarryPotterApiDataSource
): HarryPotterRepository {
    override fun getCharacters(): List<Characters> {
        return apiDataSource.getCharacters()

    }
}