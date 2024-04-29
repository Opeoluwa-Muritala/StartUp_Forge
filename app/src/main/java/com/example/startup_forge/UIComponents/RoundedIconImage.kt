package com.example.startup_forge.UIComponents

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoundedIcon(
    containerColor: Color,
    @DrawableRes icon: Int
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = containerColor.copy(alpha = 0.3f)
        ),
        shape = CircleShape,
        modifier = Modifier.size(60.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(55.dp)
        )
    }
}