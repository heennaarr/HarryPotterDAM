package com.example.harrypotterdam.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.harrypotterdam.domain.Characters
import com.example.harrypotterdam.domain.GetCharactersUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.harrypotterdam.app.ErrorApp
import kotlinx.coroutines.launch

class HarryPotterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel()  {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadCharacters() {
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch {
            val characters = getCharactersUseCase.invoke()
            _uiState.value = UiState(characters = characters)
        }
    }


data class UiState(
    val isLoading: Boolean = false,
    val characters: List<Characters> = emptyList(),
    val errorMessage: ErrorApp? = null

)
}