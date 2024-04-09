package com.example.startup_forge.AppUI.Community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.startup_forge.ui.theme.TextGray

@Composable
fun Community() {
    Column(
        Modifier
            .fillMaxSize()
            .background(TextGray),
        horizontalAlignment = Alignment.Start
    ) {
        Box(modifier = Modifier
            .background(Color.White)
            .padding(top = 10.dp)
            .fillMaxHeight()
            .width(100.dp)
            .background(Color.White)){
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(TextGray)
                    .size(60.dp))
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(TextGray)
                    .size(60.dp))
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(TextGray)
                    .size(60.dp)){
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "Addition",
                        modifier = Modifier.size(20.dp).align(Alignment.Center),
                        tint = Color.Black
                    )
                }
            }
        }
    }
}