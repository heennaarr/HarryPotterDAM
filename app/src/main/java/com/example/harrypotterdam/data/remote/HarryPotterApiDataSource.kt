package com.example.harrypotterdam.data.remote

import com.example.harrypotterdam.domain.Characters

class HarryPotterApiDataSource {
    private val characters = listOf(
        Characters("1", "Harry Potter", "Gryffindor", "Male", "Gryffindor", "https://ik.imagekit.io/hpapi/harry.jpg"),
        Characters("2 ","Hermione Granger", "Gryffindor", "Female",  "Gryffindor", "https://ik.imagekit.io/hpapi/hermione.jpeg"),
        Characters("3","Ron Weasley", "Gryffindor", "Male", "Gryffindor", "https://ik.imagekit.io/hpapi/ron.jpg"),
        Characters("4", "Draco Malfoy", "Slytherin", "Male", "Slytherin", "https://ik.imagekit.io/hpapi/draco.jpg")
        
    )
    fun getCharacters(): List<Characters> {
        return characters
    }

    fun getCharacter(id: String): Characters {
        return characters.first { it.id == id }
    }

}