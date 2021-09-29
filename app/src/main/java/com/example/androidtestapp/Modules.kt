package com.example.androidtestapp

import com.example.androidtestapp.models.UserModel
import com.example.androidtestapp.repositories.TestUserRepository
import com.example.androidtestapp.repositories.UserRepository
import com.example.androidtestapp.services.TestUserService
import com.example.androidtestapp.services.UserService
import com.example.androidtestapp.services.mappers.Mapper
import com.example.androidtestapp.services.mappers.UserModelMapper
import com.example.androidtestapp.services.responcemodels.ResponseUserModel
import com.example.androidtestapp.storages.TestUserStorage
import com.example.androidtestapp.storages.UserStorage
import com.example.androidtestapp.viewmodels.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    single<UserService> { TestUserService() }
    single<Mapper<ResponseUserModel, UserModel>> { UserModelMapper() }
    single<UserRepository> { TestUserRepository(get(), get()) }
    single<UserStorage> { TestUserStorage(get()) }

    viewModel { MainFragmentViewModel(get()) }
}