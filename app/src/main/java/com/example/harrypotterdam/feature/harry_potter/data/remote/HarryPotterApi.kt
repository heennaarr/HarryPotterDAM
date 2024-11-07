package com.example.harrypotterdam.feature.harry_potter.data.remote

data class HarryPotterApiModel(
    val id: String,
    val name: String? = null,
    val species: String? = null,
    val gender: String? = null,
    val house: String? = null,
    val image: String? = null,
    val birthYear: Int? = null,
    val deathYear: Int? = null,
    val patronus: String? = null,
    val bloodStatus: String? = null,
    val ancestry: String? = null,
    val occupation: String? = null,
    val dateOfBirth: String? = null,
    val eyeColour: String? = null,
    val actor: String? = null
)