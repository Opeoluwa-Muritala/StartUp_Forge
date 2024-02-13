package com.example.startup_forge.UIComponents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun textField(
    textFieldState: String,
    textfieldLabel: String
) {
    var text by remember {
        mutableStateOf(textFieldState)
    }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        Modifier
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(10.dp),
            )
            .heightIn(min= 40.dp, max = 50.dp)
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            cursorColor = Color.Magenta,
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black


        ),
        label = {
            Text(text = textfieldLabel)
        },
    )
}

@Composable
fun textFieldWithIcon(
    textFieldState: String,
    textfieldLabel: String,
    icons: List<Int>,
    showIcon: Boolean,
    onClickIcon: () -> Unit
) {
    var text by remember {
        mutableStateOf(textFieldState)
    }
    val icos = icons
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        Modifier
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(10.dp),
            )
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
            .heightIn(min= 40.dp, max = 50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            cursorColor = Color.Magenta,
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black

        ),
        label = {
            Text(text = textfieldLabel)
        },
        trailingIcon = {


                Icon(
                    painter = painterResource(id = if (showIcon) icos[1] else icos[0]),
                    "show",
                    modifier = Modifier.clickable {
                        onClickIcon()}.size(20.dp),
                    tint = Color.Black
                )

        },

    )
}