package com.example.characters_list.domain.repository

import com.example.characters_list.domain.model.Characters
import com.example.characters_list.domain.request.CharactersRequestOptionalParameters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters(
        page: Int,
        count: Int,
        optionalParameters: CharactersRequestOptionalParameters
    ): Flow<Characters>
}