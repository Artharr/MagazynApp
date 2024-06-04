package com.example.projekt.sekcje

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.DropdownList
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projekt.UstawieniaListItem
import com.example.projekt.nawigacja.Ekrany

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ustawienia(navController: NavController, bottomNavController: NavController, sharedPrefs: SharedPreferences){
    var listaUstawien = listOf("Tryb ciemny", "Tryb dla osób leworęcznych", "Powiększony tekst", "Wysoki kontrast", "Wyłącz powiadomienia")
    var rozwinietaLista by remember { mutableStateOf(false) }
    var jezyk by remember {
        mutableStateOf("Polski")
    }
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column {
            LazyColumn(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(listaUstawien){
                    UstawieniaListItem(opis = it)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primary)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                    Column(modifier = Modifier
                        .padding(18.dp)) {
                        Text(text = "Wybierz język", fontSize = 24.sp, color = Color.Black)
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(10.dp)){
                        ExposedDropdownMenuBox(expanded = rozwinietaLista, onExpandedChange = {rozwinietaLista = it}) {
                            TextField(value = jezyk, 
                                onValueChange = {}, 
                                readOnly = true, 
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = rozwinietaLista) }, 
                                colors = ExposedDropdownMenuDefaults.textFieldColors(), modifier = Modifier.menuAnchor())
                            ExposedDropdownMenu(expanded = rozwinietaLista, onDismissRequest = {rozwinietaLista = false}) {
                                DropdownMenuItem(
                                    text = { Text(text = "Polski")},
                                    onClick = {
                                        jezyk = "Polski"
                                        rozwinietaLista = false
                                    })
                                DropdownMenuItem(
                                    text = { Text(text = "Angielski")},
                                    onClick = {
                                        jezyk = "Angielski"
                                        rozwinietaLista = false
                                    })
                            }
                        }
                    }
                }

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