package com.example.harrypotterdam.domain

data class Characters(
    val id: String,
    val name: String,
    val species: String,
    val gender: String,
    val house: String,
    val image: String,
    val birthYear: Int? = null,           // Año de nacimiento, opcional
    val deathYear: Int? = null,           // Año de fallecimiento, opcional
    val patronus: String? = null,          // Patronus del personaje, opcional
    val wand: String? = null,              // Descripción de la varita, opcional
    val bloodStatus: String? = null,       // Estado de sangre (sangre pura, mestizo, etc.), opcional
    val ancestry: String? = null,          // Ancestros, opcional
    val occupation: String? = null,        // Ocupación del personaje, opcional
    val notableAchievements: List<String> = emptyList(), // Logros notables, opcional
    val dateOfBirth: String,
    val eyeColour: String,
    val actor: String
) {
    // Puedes agregar métodos adicionales aquí si es necesario
}
