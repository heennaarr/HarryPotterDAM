package com.example.harrypotterdam.domain

class GetCharacterSelectedUseCase(private val repository: HarryPotterRepository) {
    operator fun invoke(id: String): Characters {
        return repository.getCharacter(id)
    }

}