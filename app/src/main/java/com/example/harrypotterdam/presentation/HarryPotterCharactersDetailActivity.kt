package com.example.harrypotterdam.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.harrypotterdam.R
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.domain.Characters

class HarryPotterCharactersDetailActivity: AppCompatActivity() {
    private lateinit var harryPotterFactory: HarryPotterFactory
    private lateinit var viewModel: HarryPotterCharactersDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_detail)
        harryPotterFactory = HarryPotterFactory(this)
        viewModel = harryPotterFactory.getCharacterDetailViewModel()
        getCharacter()?.let { characterId ->
            viewModel.viewCreated(characterId)?.let { character ->
                bindData(character)

            }
        }
    }
    private fun getCharacter(): String? {
        return intent.getStringExtra(KEY_CHARACTER_ID)
    }
    private fun bindData(character: Characters) {
        findViewById<TextView>(R.id.nameCharacter).text = character.name
        findViewById<TextView>(R.id.houseCharacter).text = character.house
        val imageView = findViewById<ImageView>(R.id.imageCharacter)
        imageView.loadUrl(character.image)

    }
    companion object {
        const val KEY_CHARACTER_ID = "key_character_id"

        fun getIntent(context: Context, characterId: String): Intent {
            val intent = Intent(context, HarryPotterCharactersDetailActivity::class.java)
            intent.putExtra(KEY_CHARACTER_ID, characterId)
            return intent
        }
    }

}