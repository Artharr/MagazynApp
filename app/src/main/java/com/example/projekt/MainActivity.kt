package com.example.projekt

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projekt.nawigacja.SetupEkranyNavGraph
import com.example.projekt.ui.theme.ProjektTheme

class MainActivity : ComponentActivity() {

    lateinit var bottomNavController: NavHostController
    lateinit var ekranyNavController: NavHostController
    private var doSkompletowania: Int = 5
    private var doWydania: Int = 8


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjektTheme {
                bottomNavController = rememberNavController()
                ekranyNavController = rememberNavController()
                SetupEkranyNavGraph(
                    navController = ekranyNavController,
                    bottomNavController = bottomNavController,
                    doSkompletowania = doSkompletowania,
                    doWydania = doWydania,
                    context = this
                )
            }
        }
    }
}