package com.example.characters_list.di

import com.example.characters_list.data.mapper.CharactersMapper
import com.example.characters_list.data.repository.CharactersRepositoryImp
import com.example.characters_list.data.service.CharactersService
import com.example.characters_list.data.source.CharactersDataSource
import com.example.characters_list.data.source.CharactersDataSourceImpl
import com.example.characters_list.domain.repository.CharactersRepository
import com.example.characters_list.domain.usecase.GetCharactersUseCase
import com.example.core.network.Http
import org.koin.dsl.module

val charactersListModule = module {

    factory<CharactersDataSource> {
        CharactersDataSourceImpl(
            service = get<Http>().create(CharactersService::class.java)
        )
    }

    factory<CharactersRepository> {
        CharactersRepositoryImp(
            mapper = CharactersMapper(),
            dataSource = get()
        )
    }

    factory {
        GetCharactersUseCase(
            repository = get()
        )
    }
}