package com.example.harrypotterdam.data.remote

import com.example.harrypotterdam.domain.Characters

class HarryPotterApiDataSource {
    private val characters = listOf(
        Characters("Harry Potter", "Gryffindor", "Male", "boy","Gryffindor", "https://hp-api.onrender.com/api/characters/1"),
        Characters("Hermione Granger", "Gryffindor", "Female", "girl", "Gryffindor", "https://hp-api.onrender.com/api/characters/2"),
        Characters("Ron Weasley", "Gryffindor", "Male", "boy","Gryffindor", "https://hp-api.onrender.com/api/characters/3"),
        Characters("Draco Malfoy", "Slytherin", "Male", "boy","Slytherin", "https://hp-api.onrender.com/api/characters/4")
        
    )
    fun getCharacters(): List<Characters> {
        return characters
    }

    fun getCharacter(characterId: String): Characters? {
        return characters.firstOrNull { it.id == characterId }
    }
}