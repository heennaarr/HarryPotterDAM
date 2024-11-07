package com.example.harrypotterdam.domain

import org.koin.core.annotation.Single

@Single
class GetCharactersUseCase(private val repository: HarryPotterRepository) {
    suspend operator fun invoke(): List<Characters> {
        return repository.getCharacters()
    }
}