package com.example.androidtestapp.services.mappers

import com.example.androidtestapp.models.UserModel
import com.example.androidtestapp.services.responcemodels.ResponseUserModel

class UserModelMapper : Mapper<ResponseUserModel, UserModel> {
    override fun map(input: ResponseUserModel): UserModel {
        return UserModel(
            id = input.id,
            name = input.fio
        )
    }
}