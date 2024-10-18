package com.example.harrypotterdam.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.harrypotterdam.R
import com.example.harrypotterdam.domain.Characters

class MainActivity : AppCompatActivity() {
    private lateinit var charactersFactory: HarryPotterFactory
    private lateinit var viewModel: HarryPotterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        charactersFactory = HarryPotterFactory(this)
        setupObserver()
        viewModel.loadCharacters()


    }
    private fun setupObserver(){
        val characterObserver = Observer<HarryPotterViewModel.UiState> { uiState  ->
            uiState.characters?.let{
                binData(it)
            }
            uiState.errorApp?.let{
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
    }
}