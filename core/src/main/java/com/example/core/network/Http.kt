package com.example.core.network

import retrofit2.Retrofit

class Http(
    private val retrofit: Retrofit
) {

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}