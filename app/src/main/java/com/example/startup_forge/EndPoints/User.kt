package com.example.startup_forge.EndPoints

data class User(
    val email: String,
    val id: String,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean
)