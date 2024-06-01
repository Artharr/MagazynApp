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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Kompletowanie(navController: NavController, doSkompletowania: MutableList<OrderItem>){
    LazyColumn (verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
        .fillMaxSize()){
        items(doSkompletowania) { order -> OrderListItem(orderItem = order) }
    }
}