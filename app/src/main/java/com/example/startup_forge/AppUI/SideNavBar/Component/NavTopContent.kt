package com.example.startup_forge.AppUI.SideNavBar.Component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.startup_forge.UIComponents.RoundedIcon

@Composable
fun ProfileContent1(
    text: String,
    details: String,
    iconBackgroundColor: Color,
    @DrawableRes icon: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        RoundedIcon(containerColor = iconBackgroundColor, icon = icon)
        Spacer(modifier = Modifier.width(30.dp))
        Column {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
                )
            Text(
                text = details,
                fontWeight = FontWeight.Light,
                color = Color.LightGray
            )
        }
    }
}