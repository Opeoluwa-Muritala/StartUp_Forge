package com.example.startup_forge.data.api

import com.example.startup_forge.data.model.Register
import com.example.startup_forge.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface StartupApi {
    @POST("auth/register")
    suspend fun register(
        @Body post: Register
    ): Response<Register>

    @FormUrlEncoded
    @POST("auth/jwt/login")
    suspend fun login(
        @Field("grant_type") grant_type: String? ,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("scope") scope: String?,
        @Field("client_id") client_id: String?,
        @Field("client_secret") client_secret: String?
    ): Response<User>
}