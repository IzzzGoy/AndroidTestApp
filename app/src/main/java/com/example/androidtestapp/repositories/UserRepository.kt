package com.example.androidtestapp.repositories

import com.example.androidtestapp.models.UserModel
import com.example.androidtestapp.services.UserService
import com.example.androidtestapp.services.mappers.Mapper
import com.example.androidtestapp.services.responcemodels.ResponseUserModel

interface UserRepository {
    suspend fun fetchUser(): UserModel
}

class TestUserRepository(
    private val userService: UserService,
    private val userModelMapper: Mapper<ResponseUserModel, UserModel>,
): UserRepository {
    override suspend fun fetchUser(): UserModel {
        return userModelMapper.map(userService.fetch())
    }
}
