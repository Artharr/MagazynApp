package com.example.projekt

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projekt.ui.theme.ProjektTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private var doSkompletowania: Int = 5
    private var doWydania: Int = 8

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjektTheme {
                navController = rememberNavController()
                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Scaffold(bottomBar = {
                        NavigationBar {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = selectedItemIndex == 0,
                                    onClick = {
                                                selectedItemIndex = 0
                                                navController.navigate(Screen.Kompletowanie.route)
                                    },
                                    icon = {
                                        BadgedBox(badge = { if(doSkompletowania > 0){ Badge{ Text(text = doSkompletowania.toString())} } }) {
                                            Icon(imageVector = ImageVector.vectorResource(id=R.drawable.baseline_forklift_24), contentDescription = "Wydawanie")
                                        }
                                    },
                                    label = { Text(text = "Wydawanie") })
                                NavigationBarItem(
                                    selected = selectedItemIndex == 1,
                                    onClick = {
                                                selectedItemIndex = 1
                                                navController.navigate(Screen.Wydawanie.route)
                                    },
                                    icon = {
                                        BadgedBox(badge = { if(doWydania > 0){ Badge{ Text(text = doWydania.toString())} } }) {
                                            Icon(imageVector = ImageVector.vectorResource(id=R.drawable.baseline_publish_24), contentDescription = "Kompletowanie")
                                        }
                                    },
                                    label = { Text(text = "Kompletowanie") })
                                NavigationBarItem(
                                    selected = selectedItemIndex == 2,
                                    onClick = {
                                                selectedItemIndex = 2
                                                navController.navigate(Screen.Ustawienia.route)
                                    },
                                    icon = {
                                        Icon(imageVector = ImageVector.vectorResource(id=R.drawable.baseline_settings_24), contentDescription = "Ustawienia")
                                    },
                                    label = { Text(text = "Ustawienia") })
                            }
                        }
                    }, floatingActionButton = {
                        if(selectedItemIndex != 2){
                            FloatingActionButton(
                                onClick = { Toast.makeText(this, "*refresh*", Toast.LENGTH_SHORT).show()},) {
                                    Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_refresh_24), contentDescription = "odśwież")
                        }}
                    }, topBar = {
                        TopAppBar(title = { Text(text = "Witaj użytkowniku")}, modifier = Modifier.background(Color.LightGray))
                    }, content = {
                        paddingValues ->
                        Box(modifier = Modifier.padding(paddingValues)){
                            SetupNavGraph(navController = navController)
                        }
                    })
                }
            }
        }
    }
}