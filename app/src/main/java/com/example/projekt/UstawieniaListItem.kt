package com.example.projekt

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
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
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
import com.example.projekt.nawigacja.Sekcje

@Composable
fun UstawieniaListItem(opis: String){
    var checked by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(12.dp))
        .background(MaterialTheme.colorScheme.primary)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .padding(18.dp)) {
                Text(text = opis, fontSize = 24.sp, color = Color.Black)
            }
            Box(modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterVertically)
                .padding(10.dp)){
                Switch(checked = checked, onCheckedChange = { checked = it })
            }
        }

    }
}