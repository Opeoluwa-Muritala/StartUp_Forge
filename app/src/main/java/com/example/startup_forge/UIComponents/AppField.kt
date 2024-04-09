package com.example.startup_forge.UIComponents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.startup_forge.R

@Composable
fun AppField(
    textFieldState: String,
    textfieldLabel: String,
    valueChange: (String) -> Unit
) {

    TextField(
        value = textFieldState,
        onValueChange = valueChange
        ,
        Modifier
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(10.dp),
            )
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
fun AppFieldWithIcon(
    textFieldState: String,
    textfieldLabel: String,
    showIcon: Boolean,
    onClickIcon: () -> Unit,
    valueChange: (String) -> Unit
) {
    val icons = listOf(
        R.drawable.eyeopened,
        R.drawable.eyeclosed
    )
    TextField(
        value = textFieldState,
        onValueChange = valueChange,
        modifier = Modifier
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(10.dp),
            )
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
        trailingIcon = {
                Icon(
                    painter = painterResource(id = if (showIcon) icons[1] else icons[0]),
                    "show",
                    modifier = Modifier.clickable {
                        onClickIcon()}.size(20.dp),
                    tint = Color.Black
                )

        },
        visualTransformation = if (showIcon) VisualTransformation.None else PasswordVisualTransformation()
    )
}