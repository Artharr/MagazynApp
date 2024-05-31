package com.example.projekt.nawigacja

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projekt.sekcje.Kompletowanie
import com.example.projekt.sekcje.Ustawienia
import com.example.projekt.sekcje.Wydawanie

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupSekcjeNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Sekcje.Kompletowanie.route
        ){
        composable(
            route= Sekcje.Kompletowanie.route
        ){
            Kompletowanie(navController)
        }
        composable(
            route= Sekcje.Wydawanie.route
        ){
            Wydawanie(navController)
        }
        composable(
            route= Sekcje.Ustawienia.route
        ){
            Ustawienia(navController)
        }
    }
}