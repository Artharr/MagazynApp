package com.example.projekt

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projekt.model.Produkt

@SuppressLint("UnrememberedMutableState")
@Composable
fun ProduktListItem(produkt: Produkt){
    var checked by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(12.dp))
        .background(MaterialTheme.colorScheme.primary)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .padding(12.dp)) {
                Text(text = produkt.name, fontSize = 32.sp, color = Color.Black)
                Text(text = produkt.price.toString(), color = Color.DarkGray)
            }
            Box(modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterVertically)
                .padding(10.dp)){
                Checkbox(checked = checked, onCheckedChange = { checked = it }, colors = CheckboxDefaults.colors())
            }
        }

    }
}