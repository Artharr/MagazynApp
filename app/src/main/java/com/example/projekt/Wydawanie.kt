package com.example.projekt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun wydawanieEkran(paddingValues: PaddingValues){
    Column (verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .verticalScroll(rememberScrollState())){
        for(i in 16..30){
            OrderListItem(orderItem = OrderItem(i, LocalDateTime.parse("10:13 $i-05-2024", DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))))
        }
    }
}