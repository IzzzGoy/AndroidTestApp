package com.example.androidtestapp.services.responcemodels

import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserModel(
    val id: Long,
    val fio: String,
    val age: Int
)
