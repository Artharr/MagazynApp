package com.example.projekt.model

import kotlinx.serialization.Serializable

@Serializable
data class Produkt(
    val pcode: Int,
    val name: String,
    val price: Double
)
