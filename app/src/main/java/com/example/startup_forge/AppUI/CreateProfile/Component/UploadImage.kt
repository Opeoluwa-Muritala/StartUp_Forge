package com.example.startup_forge.AppUI.CreateProfile.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UploadImage(
    click: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable { click() }
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Box(modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(Color.LightGray))
        Column {
            Text(
                text = "Upload Image",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                text = "Make Sure File Is Below 2MB",
                fontWeight = FontWeight.Light,
                color = Color.LightGray,
                fontSize = 9.sp
            )
        }
    }
}