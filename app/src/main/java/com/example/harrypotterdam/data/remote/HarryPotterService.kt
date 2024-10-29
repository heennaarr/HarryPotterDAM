package com.example.harrypotterdam.data.remote

import com.example.harrypotterdam.domain.Characters
import retrofit2.Response
import retrofit2.http.GET

interface HarryPotterService {
    @GET("characters")
    suspend fun requestCharacters(): Response<List<Characters>>
}