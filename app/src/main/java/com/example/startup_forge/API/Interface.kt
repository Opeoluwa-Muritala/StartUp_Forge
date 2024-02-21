package com.example.startup_forge.API

import com.example.startup_forge.EndPoints.Register
import com.example.startup_forge.EndPoints.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("posts/{id}")
    fun getPostById(@Path("id") postId: Int): Call<User>

    @POST("auth/register")
    fun  signup(@Body user: Register?): Call<Register?>?

    @POST("auth/jwt/login")
    fun  login(@Body user: User?): Call<User?>?
}