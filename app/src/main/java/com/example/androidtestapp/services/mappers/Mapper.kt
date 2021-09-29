package com.example.androidtestapp.services.mappers

interface Mapper<in Input, out Output> {
    fun map(input: Input): Output
}