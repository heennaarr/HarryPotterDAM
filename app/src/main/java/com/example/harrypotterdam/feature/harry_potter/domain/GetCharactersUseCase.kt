package com.example.harrypotterdam.feature.harry_potter.domain

import org.koin.core.annotation.Single

@Single
class GetCharactersUseCase(private val harryPotterRepository: HarryPotterRepository) {
    suspend operator fun invoke(): List<Characters> {
        return harryPotterRepository.getCharacters()
    }
}