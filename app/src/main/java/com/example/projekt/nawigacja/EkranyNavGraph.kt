package com.example.projekt.nawigacja

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projekt.OrderItem
import com.example.projekt.ekrany.EkranGlowny
import com.example.projekt.ekrany.Logowanie
import com.example.projekt.ekrany.Zamowienie

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupEkranyNavGraph(navController: NavHostController, context: Context, sharedPrefs: SharedPreferences, doSkompletowania: MutableList<OrderItem>, doWydania: MutableList<OrderItem>){
    var route = Ekrany.Logowanie.route
    if(sharedPrefs.getInt("zalogowany", 0) == 1){
        route = Ekrany.EkranGlowny.route
    }
    NavHost(
        navController = navController,
        startDestination = route
    ){
        composable(
            route= Ekrany.EkranGlowny.route
        ){
            EkranGlowny(navController, context, sharedPrefs, doSkompletowania, doWydania)
        }
        composable(
            route= Ekrany.Logowanie.route
        ){
            Logowanie(navController, sharedPrefs)
        }
        composable(
            route= Ekrany.Zamowienie.route
        ){
            Zamowienie(navController)
        }
    }
}