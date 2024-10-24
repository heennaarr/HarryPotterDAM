package com.example.harrypotterdam.domain

interface HarryPotterRepository {
    fun getCharacters(): List<Characters>
    fun getCharacter(id: String): Characters


}