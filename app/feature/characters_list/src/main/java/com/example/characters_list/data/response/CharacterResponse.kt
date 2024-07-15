package com.example.characters_list.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("results") val results: List<CharacterItemResponse>? = null
)


@Serializable
data class CharacterItemResponse(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("status") val status: StatusResponse? = null,
    @SerialName("species") val species: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("gender") val gender: GenderResponse? = null,
    @SerialName("origin") val origin: LocationResponse? = null,
    @SerialName("location") val location: LocationResponse? = null,
    @SerialName("image") val image: String? = null,
    @SerialName("episode") val episode: List<String>? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("created") val created: String? = null
)

@Serializable
data class LocationResponse(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null
)

enum class GenderResponse {
    @SerialName("Male")
    MALE,
    @SerialName("Female")
    FEMALE,
    @SerialName("Genderless")
    GENDERLESS,
    @SerialName("Unknown")
    UNKNWON
}

enum class StatusResponse {
    @SerialName("Dead")
    DEAD,
    @SerialName("Alive")
    ALIVE,
    @SerialName("Unknown")
    UNKNOWN
}