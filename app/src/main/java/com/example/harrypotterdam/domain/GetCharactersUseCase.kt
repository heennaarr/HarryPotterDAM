package com.example.harrypotterdam.domain

class GetCharactersUseCase(private val repository: HarryPotterRepository) {
    suspend operator fun invoke(): List<Characters> {
        return repository.getCharacters()
    }
}