package com.example.projekt.sekcje

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Ustawienia(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Ustawienia")
    }
}