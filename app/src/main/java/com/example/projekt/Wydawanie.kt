package com.example.projekt

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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
private var orders = listOf<OrderItem>(
    OrderItem(11, LocalDateTime.parse("11:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(12, LocalDateTime.parse("12:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(13, LocalDateTime.parse("13:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(14, LocalDateTime.parse("14:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(15, LocalDateTime.parse("15:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(16, LocalDateTime.parse("16:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(17, LocalDateTime.parse("17:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(18, LocalDateTime.parse("18:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(19, LocalDateTime.parse("19:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))),
    OrderItem(20, LocalDateTime.parse("20:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")))
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Wydawanie(navController: NavController){
    LazyColumn (verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
        .fillMaxSize()){
        items(orders){order-> OrderListItem(orderItem = order)}
    }
}