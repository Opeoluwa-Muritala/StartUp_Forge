package com.example.startup_forge.data.model

data class User(
    val grant_type: String = "password",
    val email: String,
    val password: String,
    val scope: String = " ",
    val client_id: String = " ",
    val client_secret: String = " "
)

