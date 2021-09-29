package com.example.androidtestapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtestapp.models.UserModel
import com.example.androidtestapp.storages.UserStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainFragmentViewModel(
    private val userStorage: UserStorage
): ViewModel() {

    private val _user = MutableStateFlow<UserModel?>(null)
    val user: StateFlow<UserModel?>
        get() = _user.asStateFlow()

    init {
        viewModelScope.launch {
            _user.value = userStorage.loadUser()
        }
    }

}