package com.example.harrypotterdam.domain

interface HarryPotterRepository {
    suspend fun getCharacters(): List<Characters>



}