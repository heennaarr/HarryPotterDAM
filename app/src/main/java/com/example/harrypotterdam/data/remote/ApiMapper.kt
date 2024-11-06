package com.example.harrypotterdam.data.remote

import com.example.harrypotterdam.domain.Characters

fun HarryPotterApiModel.toModel(): Characters {
    return Characters(
        this.id,
        this.name,
        this.species,
        this.gender,
        this.house,
        this.image,
        this.birthYear,
        this.deathYear,
        this.patronus,
        this.bloodStatus,
        this.ancestry,
        this.occupation,
        this.dateOfBirth,
        this.eyeColour,
        this.actor
    )
}