package com.example.startup_forge.data.model

data class User(
    val grant_type: String? = null,
    val email: String,
    val password: String,
    val scope: String? = null,
    val client_id: String? = null,
    val client_secret: String? = null
)

