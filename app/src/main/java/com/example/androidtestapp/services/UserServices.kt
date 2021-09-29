package com.example.androidtestapp.services

import com.example.androidtestapp.services.responcemodels.ResponseUserModel

interface UserService {
    suspend fun fetch() : ResponseUserModel
}

class TestUserService : UserService {
    override suspend fun fetch(): ResponseUserModel {
        return ResponseUserModel(
            id = 1,
            fio = "Igor",
            age = 18
        )
    }
}