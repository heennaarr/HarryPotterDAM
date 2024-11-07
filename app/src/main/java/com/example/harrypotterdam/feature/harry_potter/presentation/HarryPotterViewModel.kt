package com.example.harrypotterdam.feature.harry_potter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.harrypotterdam.feature.harry_potter.domain.Characters
import com.example.harrypotterdam.feature.harry_potter.domain.GetCharactersUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.harrypotterdam.app.ErrorApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HarryPotterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel()  {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadCharacters() {
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            val characters = getCharactersUseCase.invoke()
            _uiState.postValue(UiState(characters = characters))

        }
    }


data class UiState(
    val isLoading: Boolean = false,
    val characters: List<Characters> = emptyList(),
    val errorMessage: ErrorApp? = null

)
}