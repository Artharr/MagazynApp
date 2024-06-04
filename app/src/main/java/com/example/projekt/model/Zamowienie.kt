package com.example.projekt.model

import kotlinx.serialization.Serializable

@Serializable
data class Zamowienie(
    var orderId: Int,
    val name: String,
    val lastName: String,
    var status: String,
    val orderDate: String,
    val employeeId: Int,
)
