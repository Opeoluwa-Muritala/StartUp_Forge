package com.example.startup_forge.data.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_forge.data.model.Register
import com.example.startup_forge.data.model.User
import com.example.startup_forge.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class MainViewModel(private val repository: Repository): ViewModel() {
    var registerResponse: MutableLiveData<Response<Register>> = MutableLiveData()
    var loginResponse: MutableLiveData<Response<User>> = MutableLiveData()

    fun register(register: Register){
        viewModelScope.launch {
            try {
                val response = repository.register(register)
                if (response.isSuccessful) {
                    registerResponse.value = response
                } else {
                    Log.e("API Error", "Error: ${response.message() + response.code() + response.body()} + ${response.raw()} + ${response.headers()} + ${response.errorBody()}")
                }
            } catch (e: IOException) {
                // Handle network error
                Log.e("Network Error", "Error: ${e.message}")
            } catch (e: Exception) {
                // Handle other errors
                Log.e("Error", "Error: ${e.message}")
            }


        }
    }
    fun login(user: User){
        viewModelScope.launch {
            try {
                val response = repository.login(user)
                if (response.isSuccessful) {
                    loginResponse.value = response
                } else {
                    Log.e("API Error", "Error:  ${response.message() + response.code() + response.body()} + ${response.raw()} + ${response.headers()} + ${response.errorBody()}")
                }
            } catch (e: IOException) {
                // Handle network error
                Log.e("Network Error", "Error: ${e.message}")
            } catch (e: Exception) {
                // Handle other errors
                Log.e("Error", "Error: ${e.message}")
            }


        }
    }
}