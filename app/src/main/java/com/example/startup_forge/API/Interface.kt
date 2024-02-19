package com.example.startup_forge.API

import com.example.startup_forge.EndPoints.Register
import com.example.startup_forge.EndPoints.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Register>

    @POST("/posts")
    suspend fun createPost(@Body post: Register): Register

    @GET("/users")
    suspend fun getUsers(): List<User>

    // Define other endpoints as needed
}