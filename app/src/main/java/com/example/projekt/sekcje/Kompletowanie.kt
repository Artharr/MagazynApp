package com.example.projekt.sekcje

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projekt.OrderItem
import com.example.projekt.OrderListItem
import com.example.projekt.model.Zamowienie
import kotlinx.serialization.json.Json
import java.net.URL

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Kompletowanie(navController: NavController, BottomNavController: NavController, zamowienia: MutableList<Zamowienie>){
    LazyColumn (verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier
        .fillMaxSize()){
        items(zamowienia){
            OrderListItem(orderItem = it, navController = navController)
        }
    }
}