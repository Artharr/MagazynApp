package com.example.projekt

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.projekt.ui.theme.ProjektTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjektTheme {
                var items by rememberSaveable {
                mutableStateOf(listOf(
                    BottomNavigationItem(
                        title = "Kompletowanie",
                        icon = R.drawable.baseline_forklift_24,
                        hasNews = true,
                        badgeCount = 2
                    ),
                    BottomNavigationItem(
                        title = "Wydawanie",
                        icon = R.drawable.baseline_publish_24,
                        hasNews = true,
                        badgeCount = 5
                    ),
                    BottomNavigationItem(
                        title = "Ustawienia",
                        icon = R.drawable.baseline_settings_24,
                        hasNews = false
                    )
                ))}
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Scaffold(bottomBar = {
                        NavigationBar {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {selectedItemIndex = index },
                                        icon = {
                                            BadgedBox(
                                                badge = {
                                                    if(item.badgeCount != null){
                                                        Badge{Text(text = item.badgeCount.toString()) }
                                                    }else if(item.hasNews){
                                                        Badge()
                                                    }
                                                }) {
                                                Icon(imageVector = ImageVector.vectorResource(id = item.icon),
                                                    contentDescription = item.title)
                                            }},
                                        label = {Text(text = item.title) })
                                }
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
                        when(selectedItemIndex){
                            0 -> kompletowanieEkran(paddingValues)
                            1 -> wydawanieEkran(paddingValues)
                        }

                    })
                }
            }
        }
    }
}