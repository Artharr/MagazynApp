package com.example.projekt.sekcje

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projekt.UstawieniaListItem
import com.example.projekt.nawigacja.Ekrany

@Composable
fun Ustawienia(navController: NavController, bottomNavController: NavController, sharedPrefs: SharedPreferences){
    var listaUstawien = listOf("Tryb ciemny", "Tryb dla osób leworęcznych", "Powiększony tekst", "Wysoki kontrast", "Wyłącz powiadomienia")
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(listaUstawien){
                UstawieniaListItem(opis = it)
            }
        }
        Column {
            Button(onClick = {
                with(sharedPrefs.edit()){
                    putInt("zalogowany", 0)
                    apply()
                }
                navController.navigate(Ekrany.Logowanie.route){ navController.popBackStack() }}) {
                Text(text = "Wyloguj!", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}