package com.example.startup_forge.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(
    text: String
) {
    Text(
        text = text,
// Header Text
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFFFF5722),

            )
    )
}