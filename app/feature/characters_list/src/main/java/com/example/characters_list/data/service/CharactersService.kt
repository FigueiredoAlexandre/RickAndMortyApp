package com.example.characters_list.data.service

import com.example.characters_list.data.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("/character")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("count") count: Int,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("gender") gender: String? = null
    ): CharacterResponse
}