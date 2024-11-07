package com.example.harrypotterdam.feature.harry_potter.data

import com.example.harrypotterdam.feature.harry_potter.data.remote.HarryPotterApiDataSource
import com.example.harrypotterdam.feature.harry_potter.domain.Characters
import com.example.harrypotterdam.feature.harry_potter.domain.HarryPotterRepository
import org.koin.core.annotation.Single

@Single
class HarryPotterDataRepository(
    private val apiDataSource: HarryPotterApiDataSource
): HarryPotterRepository {
    override suspend fun getCharacters(): List<Characters> {
        return apiDataSource.buildClient()

    }
}