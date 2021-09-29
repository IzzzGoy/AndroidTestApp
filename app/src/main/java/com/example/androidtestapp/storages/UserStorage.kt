package com.example.androidtestapp.storages

import com.example.androidtestapp.models.UserModel
import com.example.androidtestapp.repositories.UserRepository

interface UserStorage {
    suspend fun loadUser(): UserModel
}

class TestUserStorage(
    private val userRepository: UserRepository
) : UserStorage {
    override suspend fun loadUser(): UserModel {
        if (false) {
            return UserModel(
                id = -1L,
                name = "Error"
            )
        } else {
            return userRepository.fetchUser()
        }
    }
}