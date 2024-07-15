package com.example.characters_list.domain.model

data class Characters(
    val results: List<CharacterItem>
)

data class CharacterItem(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: Location,
    val location: Location,
    val image: String
)

data class Location(
    val name: String,
    val url: String
)

enum class Gender(val description: String) {
    MALE("Male"),
    FEMALE("Female"),
    GENDERLESS("Genderless"),
    UNKNOWN("UNKNOWN")
}

enum class Status(val description: String) {
    DEAD("dead"),
    ALIVE("alive"),
    UNKNOWN("unknown")
}
