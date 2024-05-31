package com.example.projekt.nawigacja

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projekt.ekrany.EkranGlowny
import com.example.projekt.ekrany.Logowanie
import com.example.projekt.ekrany.Zamowienie

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupEkranyNavGraph(navController: NavHostController, bottomNavController: NavHostController, doSkompletowania: Int, doWydania: Int, context: Context){
    NavHost(
        navController = navController,
//        startDestination = Ekrany.EkranGlowny.route
        startDestination = Ekrany.Logowanie.route
    ){
        composable(
            route= Ekrany.EkranGlowny.route
        ){
            EkranGlowny(navController, bottomNavController, doSkompletowania, doWydania, context)
        }
        composable(
            route= Ekrany.Logowanie.route
        ){
            Logowanie(navController)
        }
        composable(
            route= Ekrany.Zamowienie.route
        ){
            Zamowienie(navController)
        }
    }
}