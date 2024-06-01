package com.example.projekt.ekrany

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projekt.nawigacja.Ekrany

@Composable
fun Logowanie(navController: NavController, sharedPrefs: SharedPreferences){
    if(sharedPrefs.getInt("zalogowany", 0) == 1){
        navController.navigate(Ekrany.EkranGlowny.route){
            navController.popBackStack()
        }
    }
    var login by remember{ mutableStateOf("") }
    var haslo by remember{ mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "MagazynApp", fontSize = 48.sp)
            Spacer(modifier = Modifier.height(64.dp))
            OutlinedTextField(
                value = login,
                onValueChange = {login = it},
                label = { Text(text = "Login", fontSize = 18.sp)},
                textStyle = TextStyle.Default.copy(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = haslo,
                onValueChange = {haslo = it},
                label = { Text(text = "Haslo", fontSize = 18.sp)},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = TextStyle.Default.copy(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(36.dp))
            Button(onClick = {
                navController.navigate(Ekrany.EkranGlowny.route){
                    navController.popBackStack()
                }
                with(sharedPrefs.edit()){
                    putInt("zalogowany", 1)
                    apply()
                }
                }) {
                Text(text = "Zaloguj!", fontSize = 18.sp)
            }
        }
    }
}