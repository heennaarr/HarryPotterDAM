package com.example.harrypotterdam.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterdam.app.ErrorApp
import com.example.harrypotterdam.domain.Characters
import com.example.harrypotterdam.domain.GetCharacterSelectedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HarryPotterCharactersDetailViewModel(private val getCharacterSelectedUseCase: GetCharacterSelectedUseCase): ViewModel()
{
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(characterId: String){
        viewModelScope.launch(Dispatchers.IO) {
            val character = getCharacterSelectedUseCase.invoke(characterId)
            _uiState.postValue(UiState(character = character))
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val character : Characters? = null
    )
}