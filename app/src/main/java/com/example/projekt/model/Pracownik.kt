package com.example.projekt.model

import kotlinx.serialization.Serializable

@Serializable
data class Pracownik(
    val employeeId: Int,
    val firstName: String,
    val lastName: String,
    val login: String,
    val password: String
)