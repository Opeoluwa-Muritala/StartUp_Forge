package com.example.startup_forge.data.repository

import com.example.startup_forge.data.api.RetrofitInstance
import com.example.startup_forge.data.model.Register
import com.example.startup_forge.data.model.User
import retrofit2.Response

class Repository {
    suspend fun register(register: Register): Response<Register> {
        return RetrofitInstance.api.register(register)
    }

    suspend fun login(user: User): Response<User> {
        return RetrofitInstance.api.login(
            user.client_id,
            user.email,
            user.password,
            user.scope,
            user.client_secret,
            user.grant_type
        )
    }
}