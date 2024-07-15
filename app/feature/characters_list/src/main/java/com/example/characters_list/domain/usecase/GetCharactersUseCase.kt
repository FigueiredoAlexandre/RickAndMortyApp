package com.example.characters_list.domain.usecase

import com.example.characters_list.domain.model.Characters
import com.example.characters_list.domain.model.Gender
import com.example.characters_list.domain.model.Status
import com.example.characters_list.domain.repository.CharactersRepository
import com.example.characters_list.domain.request.CharactersRequestOptionalParameters
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
    private val repository: CharactersRepository
) {

    operator fun invoke(
        page: Int,
        count: Int,
        name: String?,
        gender: Gender?,
        status: Status?
    ): Flow<Characters> =
        repository.getCharacters(
            page = page,
            count = count,
            optionalParameters = CharactersRequestOptionalParameters(
                name = name,
                gender = gender,
                status = status
            )
        )
}