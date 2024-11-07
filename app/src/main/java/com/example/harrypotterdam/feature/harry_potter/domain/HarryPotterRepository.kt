package com.example.harrypotterdam.feature.harry_potter.domain

interface HarryPotterRepository {
    suspend fun getCharacters(): List<Characters>



}