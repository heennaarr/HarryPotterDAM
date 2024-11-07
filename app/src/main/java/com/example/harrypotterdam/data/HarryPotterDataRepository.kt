package com.example.harrypotterdam.data

import com.example.harrypotterdam.data.remote.HarryPotterApiDataSource
import com.example.harrypotterdam.domain.Characters
import com.example.harrypotterdam.domain.HarryPotterRepository
import org.koin.core.annotation.Single

@Single
class HarryPotterDataRepository(
    private val apiDataSource: HarryPotterApiDataSource
): HarryPotterRepository {
    override suspend fun getCharacters(): List<Characters> {
        return apiDataSource.buildClient()

    }


}