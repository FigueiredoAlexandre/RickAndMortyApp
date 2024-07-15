package com.example.characters_list.domain.request

import com.example.characters_list.domain.model.Gender
import com.example.characters_list.domain.model.Status

data class CharactersRequestOptionalParameters(
    val name: String? = null,
    val gender: Gender? = null,
    val status: Status? = null
)