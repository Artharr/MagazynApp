package com.example.projekt

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderListItem(orderItem: OrderItem){
    Button(onClick = {Order()},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.padding(12.dp).fillMaxWidth()) {
            Text(text = "Zamówienie " + orderItem.orderID.toString(), fontSize = 32.sp, color = Color.Black)
            Text(text = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy").format(orderItem.orderDate), color = Color.DarkGray)
        }
    }
}