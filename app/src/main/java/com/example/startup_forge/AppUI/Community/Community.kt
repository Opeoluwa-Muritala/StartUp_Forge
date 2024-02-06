package com.example.startup_forge.AppUI.Community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.startup_forge.AppRoute
import com.example.startup_forge.ui.theme.TextGray

@Composable
fun Community() {
    Column(
        Modifier
            .fillMaxSize()
            .background(TextGray)
    ) {
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(400.dp)
            .background(Color.White)){
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.clip(CircleShape).background(TextGray).size(80.dp))
            }
        }
    }
}