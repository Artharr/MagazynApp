package com.example.projekt.ekrany

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.projekt.OrderItem
import com.example.projekt.R
import com.example.projekt.nawigacja.Sekcje
import com.example.projekt.nawigacja.SetupSekcjeNavGraph
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EkranGlowny(navController: NavHostController, context: Context, sharedPrefs: SharedPreferences, doSkompletowania: MutableList<OrderItem>, doWydania: MutableList<OrderItem>){
    val bottomNavController: NavHostController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val nazwaUzytkownika = sharedPrefs.getString("nazwaUzytkownika", "")
    Scaffold(bottomBar = {
        BottomNavigation(bottomNavController = bottomNavController, navBackStackEntry = navBackStackEntry, doSkompletowania = doSkompletowania, doWydania = doWydania
        )
    }, floatingActionButton = {
        if(currentDestination?.hierarchy?.any{
                it.route == Sekcje.Ustawienia.route
            }==false){
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "*refresh*", Toast.LENGTH_SHORT).show()
                    if(currentDestination.hierarchy.any{it.route==Sekcje.Kompletowanie.route}){
                        doSkompletowania.add(OrderItem(Random.nextInt(0,100),
                            LocalDateTime.parse(Random.nextInt(10,23).toString()+":"+
                                    Random.nextInt(10,59)+" "+
                                    Random.nextInt(10,28)+"-"+
                                    Random.nextInt(10,12)+"-2024",
                                DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))))
                    }
                    if(currentDestination.hierarchy.any{it.route==Sekcje.Wydawanie.route}){
                        doWydania.add(OrderItem(Random.nextInt(0,100), LocalDateTime.parse(Random.nextInt(10,23).toString()+":"+Random.nextInt(10,59)+" "+Random.nextInt(10,28)+"-"+Random.nextInt(10,12)+"-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))))
                    }
                }) {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_refresh_24), contentDescription = "odśwież")
            }
        }
    }, topBar = {
        TopAppBar(title = { Text(text = "Witaj "+nazwaUzytkownika) }, modifier = Modifier.background(Color.LightGray))
    }, content = {
            paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            SetupSekcjeNavGraph(bottomNavController, navController, sharedPrefs, doSkompletowania, doWydania)
        }
    })
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(bottomNavController: NavHostController, navBackStackEntry: NavBackStackEntry?, doSkompletowania: MutableList<OrderItem>, doWydania: MutableList<OrderItem>){
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        NavigationBar {
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any{ it.route == Sekcje.Kompletowanie.route } == true,
                onClick = {
                    bottomNavController.navigate(Sekcje.Kompletowanie.route){
                        popUpTo(bottomNavController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    BadgedBox(badge = { if(doSkompletowania.isNotEmpty()){ Badge{ Text(text = doSkompletowania.count().toString()) } } }) {
                        Icon(imageVector = ImageVector.vectorResource(id= R.drawable.baseline_forklift_24), contentDescription = "Wydawanie")
                    }
                },
                label = { Text(text = "Wydawanie") })
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any{ it.route == Sekcje.Wydawanie.route } == true,
                onClick = {
                    bottomNavController.navigate(Sekcje.Wydawanie.route){
                        popUpTo(bottomNavController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    BadgedBox(badge = { if(doWydania.isNotEmpty()){ Badge{ Text(text = doWydania.count().toString()) } } }) {
                        Icon(imageVector = ImageVector.vectorResource(id= R.drawable.baseline_publish_24), contentDescription = "Kompletowanie")
                    }
                },
                label = { Text(text = "Kompletowanie") })
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any{ it.route == Sekcje.Ustawienia.route } == true,
                onClick = {
                    bottomNavController.navigate(Sekcje.Ustawienia.route){
                        popUpTo(bottomNavController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = ImageVector.vectorResource(id= R.drawable.baseline_settings_24), contentDescription = "Ustawienia")
                },
                label = { Text(text = "Ustawienia") })
        }
    }
}