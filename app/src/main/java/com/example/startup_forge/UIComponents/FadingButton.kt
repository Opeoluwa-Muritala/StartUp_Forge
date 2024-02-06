package com.example.startup_forge.UIComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startup_forge.ui.theme.TextGray
import com.example.startup_forge.ui.theme.ThemeOrange

@Composable
fun FadingButton(
    buttonState: ButtonState,
    onFadingButtonClick:() -> Unit,
) {
    var alpha = 1f
    if (!buttonState.show)
    {
        alpha = 0.4f
    }


    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(260.dp)
            .height(51.dp)
            .background(color = ThemeOrange.copy(alpha), shape = RoundedCornerShape(size = 8.dp))
            .padding(start = 32.dp, top = 16.dp, end = 32.dp, bottom = 16.dp)
            .clickable { onFadingButtonClick() }
    ) {
            Text(
                text = buttonState.text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = TextGray,
                ),
            )

    }
}

@Stable
data class ButtonState(
    val text:  String,
    val show: Boolean
)