package com.example.startup_forge.UIComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MiddleSlot(
) {
    val columnNumber = 20
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        repeat(columnNumber) {
            Text("-")
        }
        Spacer(Modifier.width(10.dp))
        Text(
            text = "or",

            color = Color.Black
        )
        Spacer(Modifier.width(10.dp))

        repeat(columnNumber) {
            Text("-")
        }
    }

}