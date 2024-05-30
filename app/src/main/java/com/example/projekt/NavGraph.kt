package com.example.projekt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Kompletowanie.route
        ){
        composable(
            route=Screen.Kompletowanie.route
        ){
            Kompletowanie(navController)
        }
        composable(
            route=Screen.Wydawanie.route
        ){
            Wydawanie(navController)
        }
        composable(
            route=Screen.Ustawienia.route
        ){
            Ustawienia(navController)
        }
    }
}