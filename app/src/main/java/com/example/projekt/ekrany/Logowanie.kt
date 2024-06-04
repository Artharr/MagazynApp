package com.example.projekt.ekrany

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.example.projekt.NotificationChecker
import com.example.projekt.model.Pracownik
import com.example.projekt.nawigacja.Ekrany
import kotlinx.serialization.json.Json
import org.json.JSONArray
import java.net.URL

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
            Text(text = "Virtual Warehouse", fontSize = 48.sp, textAlign = TextAlign.Center, lineHeight = 54.sp)
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
                val pracownicy = Json.decodeFromString<List<Pracownik>>(URL("https://elite-anvil-425309-b6.lm.r.appspot.com/employee").readText())
                pracownicy.forEach {
                    if(it.login == login){
                        if(it.password == haslo){
                            navController.navigate(Ekrany.EkranGlowny.route){
                                navController.popBackStack()
                            }
                            with(sharedPrefs.edit()){
                                putInt("zalogowany", 1)
                                putString("nazwaUzytkownika", it.firstName+" "+it.lastName)
                                putInt("idUzytkownika", it.employeeId)
                                apply()

                            }

                        }
                    }
                }
                }) {
                Text(text = "Zaloguj!", fontSize = 18.sp)
            }
        }
    }
}