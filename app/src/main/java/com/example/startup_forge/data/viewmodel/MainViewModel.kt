package com.example.startup_forge.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_forge.data.model.Register
import com.example.startup_forge.data.model.User
import com.example.startup_forge.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    var registerResponse: MutableLiveData<Response<Register>> = MutableLiveData()
    var loginResponse: MutableLiveData<Response<User>> = MutableLiveData()

    fun register(register: Register){
        viewModelScope.launch {
            val response = repository.register(register)
            registerResponse.value = response
        }
    }
    fun login(user: User){
        viewModelScope.launch {
            val response = repository.login(user)
            loginResponse.value = response
        }
    }
}