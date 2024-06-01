package com.example.projekt

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projekt.nawigacja.SetupEkranyNavGraph
import com.example.projekt.ui.theme.ProjektTheme

class MainActivity : ComponentActivity() {
    lateinit var ekranyNavController: NavHostController
    var doSkompletowania = mutableStateListOf<OrderItem>()
    val doWydania = mutableStateListOf<OrderItem>()
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjektTheme {
                val sharedPrefs = getPreferences(Context.MODE_PRIVATE)
                ekranyNavController = rememberNavController()
                Surface(modifier = Modifier.fillMaxWidth()) {
                    SetupEkranyNavGraph(
                        navController = ekranyNavController,
                        context = this,
                        sharedPrefs = sharedPrefs,
                        doSkompletowania = doSkompletowania,
                        doWydania = doWydania,
                    )
                }
            }
        }
    }
}