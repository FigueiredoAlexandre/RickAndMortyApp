package com.example.rickandmorty

import android.app.Application
import com.example.characters_list.di.charactersListModule
import com.example.core.network.di.networkModule
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(networkModule, charactersListModule)
            )
        }
    }
}