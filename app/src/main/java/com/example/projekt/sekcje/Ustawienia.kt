package com.example.projekt.sekcje

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.projekt.nawigacja.Ekrany

@Composable
fun Ustawienia(navController: NavController, bottomNavController: NavController, sharedPrefs: SharedPreferences){
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            with(sharedPrefs.edit()){
                putInt("zalogowany", 0)
                apply()
            }
            navController.navigate(Ekrany.Logowanie.route){ navController.popBackStack() }}) {
          Text(text = "Wyloguj!")
        }
    }
}