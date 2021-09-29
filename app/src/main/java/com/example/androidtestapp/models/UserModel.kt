package com.example.androidtestapp.models

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val id: Long,
    val name: String
)
