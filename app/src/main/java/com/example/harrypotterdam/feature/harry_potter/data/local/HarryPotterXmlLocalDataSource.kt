package com.example.harrypotterdam.feature.harry_potter.data.local

import android.content.Context
import com.example.harrypotterdam.R
import com.example.harrypotterdam.feature.harry_potter.domain.Characters
import com.google.gson.Gson
import org.koin.core.annotation.Single

@Single
class HarryPotterXmlLocalDataSource( private val context: Context, private val gson: Gson) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_name), Context.MODE_PRIVATE
    )

    fun saveAll(characters: List<Characters>) {
        val editor = sharedPref.edit()
        characters.forEach { character ->
            editor.putString(character.id, gson.toJson(character))

        }
        editor.apply()

    }

    fun findAll(): List<Characters> {
        val characters = ArrayList<Characters>()
        val mapMushroom = sharedPref.all

        mapMushroom.values.forEach { jsonCharacter ->

            val mushroom = gson.fromJson(jsonCharacter as String, Characters::class.java)
            characters.add(mushroom)

        }
        return characters
    }
}