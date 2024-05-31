package com.example.projekt.sekcje

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projekt.OrderItem
import com.example.projekt.OrderListItem
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
private var orders = listOf(
    OrderItem(1, LocalDateTime.parse("01:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(2, LocalDateTime.parse("02:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(3, LocalDateTime.parse("03:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(4, LocalDateTime.parse("04:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(5, LocalDateTime.parse("05:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(6, LocalDateTime.parse("06:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(7, LocalDateTime.parse("07:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(8, LocalDateTime.parse("08:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(9, LocalDateTime.parse("09:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(10, LocalDateTime.parse("10:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")))
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Kompletowanie(navController: NavController){
    LazyColumn (verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
        .fillMaxSize()){
        items(orders) { order -> OrderListItem(orderItem = order) }
    }
}