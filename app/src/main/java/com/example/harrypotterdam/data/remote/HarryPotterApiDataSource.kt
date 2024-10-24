package com.example.harrypotterdam.data.remote

import com.example.harrypotterdam.domain.Characters

class HarryPotterApiDataSource {
    private val characters = listOf(
        Characters("1", "Harry Potter", "Gryffindor", "Male", "Gryffindor", "https://hp-api.onrender.com/api/characters/1"),
        Characters("2 ","Hermione Granger", "Gryffindor", "Female",  "Gryffindor", "https://hp-api.onrender.com/api/characters/2"),
        Characters("3","Ron Weasley", "Gryffindor", "Male", "Gryffindor", "https://hp-api.onrender.com/api/characters/3"),
        Characters("4", "Draco Malfoy", "Slytherin", "Male", "Slytherin", "https://hp-api.onrender.com/api/characters/4")
        
    )
    fun getCharacters(): List<Characters> {
        return characters
    }


}