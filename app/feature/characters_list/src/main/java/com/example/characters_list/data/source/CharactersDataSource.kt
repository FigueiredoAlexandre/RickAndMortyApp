package com.example.characters_list.data.source

import com.example.characters_list.data.response.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharactersDataSource {

    fun getCharacters(
        page: Int,
        count: Int,
        name: String?,
        status: String?,
        gender: String?
    ): Flow<CharacterResponse>
}