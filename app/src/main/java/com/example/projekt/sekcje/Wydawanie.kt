package com.example.projekt.sekcje

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projekt.OrderItem
import com.example.projekt.OrderListItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Wydawanie(navController: NavController, BottomNavController: NavController, doWydania: MutableList<OrderItem>){
    LazyColumn (verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
        .fillMaxSize()){
        items(doWydania){ order-> OrderListItem(orderItem = order, navController = navController) }
    }
}