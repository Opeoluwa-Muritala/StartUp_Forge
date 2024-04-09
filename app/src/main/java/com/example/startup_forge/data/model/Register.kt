package com.example.startup_forge.data.model

data class Register(
    val email: String,
    val password: String,
    val is_active: Boolean = true,
    val is_superuser: Boolean = false,
    val is_verified: Boolean = false,

)