package com.example.projekt.model

import kotlinx.serialization.Serializable

@Serializable
data class Zamowienie(
    val orderId: Int,
    val name: String,
    val lastName: String,
    val status: String,
    val orderDate: String,
    val employeeId: Int
)
