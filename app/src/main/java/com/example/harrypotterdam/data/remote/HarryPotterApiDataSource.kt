package com.example.harrypotterdam.data.remote

import com.example.harrypotterdam.domain.Characters

class HarryPotterApiDataSource(private val harryPotterService: HarryPotterService) {
   /* private val characters = listOf(
        Characters(
            id = "1",
            name = "Harry Potter",
            actor = "Daniel Radcliffe",
            species = "Humano",
            gender = "Masculino",
            house = "Gryffindor",
            image = "https://ik.imagekit.io/hpapi/harry.jpg",
            birthYear = 1980,
            deathYear = null,
            patronus = "Ciervo",
            wand = "Madera de sauce, núcleo de pluma de fénix",
            eyeColour = "Verdes",
            bloodStatus = "Sangre pura",
            ancestry = "Potter",
            occupation = "Auror",
            notableAchievements = listOf("Derrotar a Voldemort", "Ganador del Torneo de los Tres Magos"),
            dateOfBirth = "31-07-1980",
        ),
        Characters(
            id = "2",
            name = "Hermione Granger",
            actor = "Emma Watson",
            species = "Humano",
            gender = "Femenino",
            house = "Gryffindor",
            image = "https://ik.imagekit.io/hpapi/hermione.jpeg",
            birthYear = 1979,
            deathYear = null,
            patronus = "Nutria",

            wand = "Madera de vid, núcleo de pelo de unicornio",
            bloodStatus = "Mestiza",
            ancestry = "Granger",
            occupation = "Ministra de Magia",
            notableAchievements = listOf("Fundadora de la S.P.E.W.", "Top de su clase en Hogwarts"),
            dateOfBirth = "19-09-1979",
            eyeColour = "Marrones",
        ),
        Characters(
            id = "3",
            name = "Ron Weasley",
            actor = "Rupert Grint",
            species = "Humano",
            gender = "Masculino",
            house = "Gryffindor",
            image = "https://ik.imagekit.io/hpapi/ron.jpg",
            birthYear = 1980,
            deathYear = null,
            patronus = "Perro",
            wand = "Madera de pino, núcleo de pelo de unicornio",
            bloodStatus = "Sangre pura",
            ancestry = "Weasley",
            occupation = "Auror",
            notableAchievements = listOf("Participante en la batalla de Hogwarts"),
            dateOfBirth = "01-03-1980",
            eyeColour = "Azul",
        ),
        Characters(
            id = "4",
            name = "Draco Malfoy",
            actor = "Tom Felton",
            species = "Humano",
            gender = "Masculino",
            house = "Slytherin",
            image = "https://ik.imagekit.io/hpapi/draco.jpg",
            birthYear = 1980,
            deathYear = null,
            patronus = "Jabalí",
            wand = "Madera de espino, núcleo de pluma de fénix",
            bloodStatus = "Sangre pura",
            ancestry = "Malfoy",
            occupation = "Auror",
            notableAchievements = listOf("Ayudante en la batalla de Hogwarts"),
            dateOfBirth = "05-06-1980",
            eyeColour = "Gris",
        )
    )

    fun getCharacters(): List<Characters> {
        return characters
    }

    fun getCharacter(id: String): Characters {
        return characters.first { it.id == id }
    }*/
   suspend fun buildClient(): List<Characters> {
       //isSuccessful te dice que si ha ido  bien
       harryPotterService.requestCharacters().body()!!
       return emptyList()
   }



}