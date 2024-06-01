package com.example.projekt

import androidx.compose.runtime.MutableState
import java.time.LocalDateTime

data class OrderItem(
    val orderID: Int,
    val orderDate: LocalDateTime
)
