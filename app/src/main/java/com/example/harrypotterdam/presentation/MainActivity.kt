package com.example.harrypotterdam.presentation

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import androidx.lifecycle.Observer
import com.example.harrypotterdam.R
import com.example.harrypotterdam.app.ErrorApp
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.domain.Characters
import kotlin.math.log

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
        findViewById<TextView>(R.id.houseCharacter1).text = characters[0].house
        val imageView1 = findViewById<ImageView>(R.id.imageCharacter1)
        imageView1.loadUrl(characters[0].image)
        findViewById<TextView>(R.id.nameCharacter2).text = characters[1].name
        findViewById<TextView>(R.id.houseCharacter2).text = characters[1].house
        val imageView2 = findViewById<ImageView>(R.id.imageCharacter2)
        imageView2.loadUrl(characters[1].image)
        findViewById<TextView>(R.id.nameCharacter3).text = characters[2].name
        findViewById<TextView>(R.id.houseCharacter3).text = characters[2].house
        val imageView3 = findViewById<ImageView>(R.id.imageCharacter3)
        imageView3.loadUrl(characters[2].image)
        findViewById<TextView>(R.id.nameCharacter4).text = characters[3].name
        findViewById<TextView>(R.id.houseCharacter4).text = characters[3].house
        val imageView4 = findViewById<ImageView>(R.id.imageCharacter4)
        imageView4.loadUrl(characters[3].image)

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
