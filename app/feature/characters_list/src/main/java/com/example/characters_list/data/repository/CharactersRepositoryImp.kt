package com.example.characters_list.data.repository

import com.example.characters_list.data.mapper.CharactersMapper
import com.example.characters_list.data.source.CharactersDataSource
import com.example.characters_list.domain.model.Characters
import com.example.characters_list.domain.repository.CharactersRepository
import com.example.characters_list.domain.request.CharactersRequestOptionalParameters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharactersRepositoryImp(
    private val dataSource: CharactersDataSource,
    private val mapper: CharactersMapper
) : CharactersRepository {

    override fun getCharacters(
        page: Int,
        count: Int,
        optionalParameters: CharactersRequestOptionalParameters
    ): Flow<Characters> = dataSource.getCharacters(
        page = page,
        count = count,
        gender = optionalParameters.gender?.description,
        name = optionalParameters.name,
        status = optionalParameters.status?.description
    ).map { obtainedResponse ->
        mapper.map(obtainedResponse)
    }
}