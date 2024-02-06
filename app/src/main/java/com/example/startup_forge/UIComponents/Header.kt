package com.example.startup_forge.UIComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.startup_forge.ui.theme.ThemeOrange

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
            color = ThemeOrange,

            )
    )
}