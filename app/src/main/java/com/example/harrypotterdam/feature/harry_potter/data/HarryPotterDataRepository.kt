package com.example.harrypotterdam.feature.harry_potter.data

import com.example.harrypotterdam.feature.harry_potter.data.local.HarryPotterXmlLocalDataSource
import com.example.harrypotterdam.feature.harry_potter.data.remote.HarryPotterApiDataSource
import com.example.harrypotterdam.feature.harry_potter.domain.Characters
import com.example.harrypotterdam.feature.harry_potter.domain.HarryPotterRepository
import org.koin.core.annotation.Single

@Single
class HarryPotterDataRepository(
    private val apiDataSource: HarryPotterApiDataSource,
    private val localDataSource: HarryPotterXmlLocalDataSource
): HarryPotterRepository {
    override suspend fun getCharacters(): List<Characters> {
        val charactersFromLocal = localDataSource.findAll()
        return if (charactersFromLocal.isEmpty()) {
            val charactersFromApi = apiDataSource.getCharacters()
            localDataSource.saveAll(charactersFromApi)
            charactersFromApi
        } else {
            charactersFromLocal
        }

    }
}