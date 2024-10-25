package com.example.harrypotterdam.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harrypotterdam.R

class HarryPotterCharactersDetailActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_harrypotterdetail)
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