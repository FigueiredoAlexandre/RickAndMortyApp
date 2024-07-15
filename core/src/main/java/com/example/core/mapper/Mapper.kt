package com.example.core.mapper

interface Mapper<S, R> {

    fun map(source: S): R
}