package com.example.startup_forge.data.api

import com.example.startup_forge.data.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: StartupApi by lazy {
        retrofit.create(StartupApi::class.java)
    }
}