package com.example.projekt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projekt.nawigacja.Ekrany
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderListItem(orderItem: OrderItem, navController: NavController){
    Button(onClick = {
        navController.navigate(Ekrany.Zamowienie.route+"/"+orderItem.orderID.toString())},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.padding(12.dp).fillMaxWidth()) {
            Text(text = "Zamówienie " + orderItem.orderID.toString(), fontSize = 32.sp, color = Color.Black)
            Text(text = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy").format(orderItem.orderDate), color = Color.DarkGray)
        }
    }
}