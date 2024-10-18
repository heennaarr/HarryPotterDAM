package com.example.harrypotterdam.domain

class GetCharactersUseCase(private val repository: HarryPotterRepository) {
    operator fun invoke(): List<Characters> {
        return repository.getCharacters()
    }
}