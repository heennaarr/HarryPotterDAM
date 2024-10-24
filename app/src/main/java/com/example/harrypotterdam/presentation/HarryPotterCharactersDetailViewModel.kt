package com.example.harrypotterdam.presentation

import androidx.lifecycle.ViewModel
import com.example.harrypotterdam.domain.Characters
import com.example.harrypotterdam.domain.GetCharacterSelectedUseCase

class HarryPotterCharactersDetailViewModel(private val getCharacterSelectedUseCase: GetCharacterSelectedUseCase): ViewModel()
{
     fun viewCreated(characterId: String): Characters? {
    return getCharacterSelectedUseCase.invoke(characterId)
}
}