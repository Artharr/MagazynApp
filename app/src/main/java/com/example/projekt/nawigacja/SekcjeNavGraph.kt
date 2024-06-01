package com.example.projekt.nawigacja

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projekt.OrderItem
import com.example.projekt.sekcje.Kompletowanie
import com.example.projekt.sekcje.Ustawienia
import com.example.projekt.sekcje.Wydawanie

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupSekcjeNavGraph(bottomNavController: NavHostController,
                        navController: NavController,
                        sharedPrefs: SharedPreferences,
                        doSkompletowania: MutableList<OrderItem>,
                        doWydania: MutableList<OrderItem>){
    NavHost(
        navController = bottomNavController,
        startDestination = Sekcje.Kompletowanie.route
        ){
        composable(
            route= Sekcje.Kompletowanie.route
        ){
            Kompletowanie(navController, bottomNavController, doSkompletowania)
        }
        composable(
            route= Sekcje.Wydawanie.route
        ){
            Wydawanie(navController, bottomNavController, doWydania)
        }
        composable(
            route= Sekcje.Ustawienia.route
        ){
            Ustawienia(navController, bottomNavController, sharedPrefs)
        }
    }
}