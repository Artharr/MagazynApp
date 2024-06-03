package com.example.projekt.ekrany

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projekt.model.Produkt
import com.example.projekt.ProduktListItem
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.net.URL


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun Zamowienie(navController: NavController, nrZamowienia: Int?){
    var json = URL("https://elite-anvil-425309-b6.lm.r.appspot.com/order/"+nrZamowienia).readText()
    var dane = JSONObject(json)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Zamówienie nr. $nrZamowienia") },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.Filled.ArrowBack, "Powrót")
                    }
                })
        },
        content = {
            paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)){
                Text(text = dane.get("name").toString() + " " + dane.get("lastName").toString() + " (" + dane.get("orderDate").toString() + ")",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
                var produkty = Json.decodeFromString<List<Produkt>>(URL("https://elite-anvil-425309-b6.lm.r.appspot.com/product").readText())
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxSize()) {
                    items(produkty){
                        ProduktListItem(produkt = it)
                    }
                }
            }
        })
}