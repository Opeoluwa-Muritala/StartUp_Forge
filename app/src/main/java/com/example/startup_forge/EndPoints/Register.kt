package com.example.startup_forge.EndPoints

data class Register(
    val email: String,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean,
    val password: String
)