package com.example.characters_list.data.mapper

import com.example.characters_list.data.response.CharacterItemResponse
import com.example.characters_list.data.response.CharacterResponse
import com.example.characters_list.data.response.GenderResponse
import com.example.characters_list.data.response.LocationResponse
import com.example.characters_list.data.response.StatusResponse
import com.example.characters_list.domain.model.CharacterItem
import com.example.characters_list.domain.model.Characters
import com.example.characters_list.domain.model.Gender
import com.example.characters_list.domain.model.Location
import com.example.characters_list.domain.model.Status
import com.example.core.mapper.Mapper


private const val HYPHEN = "-"

class CharactersMapper : Mapper<CharacterResponse, Characters> {

    override fun map(source: CharacterResponse): Characters {
        return Characters(
            results = mapResults(source.results)
        )
    }

    private fun mapResults(source: List<CharacterItemResponse>?): List<CharacterItem> {
        return source?.map { itemResponse ->
            CharacterItem(
                id = itemResponse.id ?: 0,
                name = itemResponse.name.orEmpty(),
                status = mapStatus(itemResponse.status),
                species = itemResponse.species.orEmpty(),
                type = itemResponse.type.orEmpty(),
                gender = mapGender(itemResponse.gender),
                origin = mapLocation(itemResponse.origin),
                location = mapLocation(itemResponse.location),
                image = itemResponse.image.orEmpty()
            )
        } ?: emptyList()
    }

    private fun mapStatus(source: StatusResponse?): Status {
        return source?.let {
            when (it) {
                StatusResponse.ALIVE -> Status.ALIVE
                StatusResponse.DEAD -> Status.DEAD
                StatusResponse.UNKNOWN -> Status.UNKNOWN
            }
        } ?: Status.UNKNOWN
    }

    private fun mapGender(source: GenderResponse?): Gender {
        return source?.let {
            when (it) {
                GenderResponse.GENDERLESS -> Gender.GENDERLESS
                GenderResponse.FEMALE -> Gender.FEMALE
                GenderResponse.MALE -> Gender.MALE
                GenderResponse.UNKNWON -> Gender.UNKNOWN
            }
        } ?: Gender.UNKNOWN
    }

    private fun mapLocation(location: LocationResponse?): Location {
        return location?.let {
            Location(
                name = it.name ?: HYPHEN,
                url = it.url ?: HYPHEN
            )
        } ?: Location(
            name = HYPHEN,
            url = HYPHEN
        )
    }
}