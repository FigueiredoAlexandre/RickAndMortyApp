package com.example.characters_list.data.source

import com.example.characters_list.data.response.CharacterResponse
import com.example.characters_list.data.service.CharactersService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharactersDataSourceImpl(
    private val service: CharactersService
) : CharactersDataSource {

    override fun getCharacters(
        page: Int,
        count: Int,
        name: String?,
        status: String?,
        gender: String?
    ): Flow<CharacterResponse> {
        return flow {
            try {
                emit(service.getCharacters(page, count, name, status, gender))
            } catch (e: Exception) {
                throw e
            }
        }
    }
}