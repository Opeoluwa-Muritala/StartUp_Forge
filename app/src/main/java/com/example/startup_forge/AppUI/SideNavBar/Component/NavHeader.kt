package com.example.startup_forge.AppUI.SideNavBar.Component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun NavHeader(
    @DrawableRes image: Int,
    name: String,
    click: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth().clickable {
            click()
        }
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(50.dp)
        )
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                text = "view profile",
                fontWeight = FontWeight.Light,
                color = Color.LightGray,
                textDecoration = TextDecoration.Underline
            )
        }
    }

}