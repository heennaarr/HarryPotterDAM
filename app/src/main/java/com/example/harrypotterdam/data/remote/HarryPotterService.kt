package com.example.harrypotterdam.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface HarryPotterService {
    @GET
    fun requestCharacters():Response<List<HarryPotterApiModel>>
}