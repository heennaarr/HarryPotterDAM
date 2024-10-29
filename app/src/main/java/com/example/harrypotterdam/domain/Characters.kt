package com.example.harrypotterdam.domain
data class Characters(
    val id: String,
    val name: String,
    val species: String,
    val gender: String,
    val house: String,
    val image: String,
    val birthYear: Int? = null,
    val deathYear: Int? = null,
    val patronus: String? = null,
    val wand: Wand? = null,                // Cambiado a tipo Wand
    val bloodStatus: String? = null,
    val ancestry: String? = null,
    val occupation: String? = null,
    val notableAchievements: List<String> = emptyList(),
    val dateOfBirth: String,
    val eyeColour: String,
    val actor: String
) {
    // Métodos adicionales aquí si es necesario
}
data class Wand(
    val wood: String? = null,
    val core: String? = null,
    val length: Double? = null
)


