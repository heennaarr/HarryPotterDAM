package com.example.harrypotterdam.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.harrypotterdam.R
import com.example.harrypotterdam.app.ErrorApp
import com.example.harrypotterdam.domain.Characters

class MainActivity : AppCompatActivity() {
    private lateinit var charactersFactory: HarryPotterFactory
    private lateinit var viewModel: HarryPotterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        charactersFactory = HarryPotterFactory(this)
        viewModel = charactersFactory.getCharactersListViewModel()
        setupObserver()
        viewModel.loadCharacters()


    }
    private fun setupObserver() {
        val characterObserver = Observer<HarryPotterViewModel.UiState> { uiState ->
            uiState.characters?.let {
                bindData(it)
            }
            uiState.errorMessage?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev", " Cargado ...")
            }
        }
        viewModel.uiState.observe(this, characterObserver)

    }
    private fun bindData(characters: List<Characters>) {
        findViewById<TextView>(R.id.nameCharacter1).text = characters[0].name
        findViewById<TextView>(R.id.nameCharacter2).text = characters[1].name
        findViewById<TextView>(R.id.nameCharacter3).text = characters[2].name
        findViewById<TextView>(R.id.nameCharacter4).text = characters[3].name

        }


    }
    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
            ErrorApp.TestErrorApp -> TODO()
        }
    }
