package com.example.projekt

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projekt.ui.theme.ProjektTheme
import java.text.DecimalFormat
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
                val orderList = listOf(
                    OrderItem(
                        orderID = 1,
                        orderDate = LocalDateTime.parse("10:10 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))
                    ),
                    OrderItem(
                        orderID = 2,
                        orderDate = LocalDateTime.parse("10:13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))
                    )
                )
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
                            FloatingActionButton(onClick = {
                                Toast.makeText(this, "*refresh*", Toast.LENGTH_SHORT).show()}) {
                                Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_refresh_24), contentDescription = "odśwież")
                        }}
                    }, topBar = {
                        TopAppBar(title = { Text(text = "Witaj użytkowniku")}, modifier = Modifier.background(Color.LightGray))
                    }, content = {
                        paddingValues ->
                        Column (verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState())){
//                                orderList.forEachIndexed { index, orderItem ->
//                                    orderListItem(orderItem = orderItem)
//                                }
                            for(i in 1..20){
                                OrderListItem(orderItem = OrderItem(i, LocalDateTime.parse(DecimalFormat("00").format(i).toString()+":13 18-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))))
                            }
                        }
                    })
                }
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun OrderListItem(orderItem: OrderItem){
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(modifier = Modifier.padding(12.dp).fillMaxWidth()) {
                Text(text = "Zamówienie " + orderItem.orderID.toString(), fontSize = 32.sp, color = Color.Black)
                Text(text = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy").format(orderItem.orderDate), color = Color.DarkGray)
            }
        }
    }
}