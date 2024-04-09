package com.example.startup_forge.UIComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun DropDownTextField(
    modifier: Modifier = Modifier,
    label: String,
    list: List<Any>,
    onDropCLick: () -> Unit,
    show: Boolean= true,
    text: MutableState<String>
) {
    Column {
        OutlinedTextField(
            value = text.value,
            onValueChange = {text.value =  it},
            label = {
                Text(text = label)
            },
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "Select Items",
                    tint = Color.Black,
                    modifier = Modifier.clickable { onDropCLick() }
                )
            },
            modifier = modifier
        )
        DropdownMenu(
            expanded = show,
            onDismissRequest = { onDropCLick() },
            offset = DpOffset(1.dp, 5.dp),
            modifier = modifier.background(Color.White).height(150.dp)) {
            list.forEach {
                DropdownMenuItem(
                    text = { Text(text = "$it") },
                    onClick = { text.value = it.toString()
                        onDropCLick()  }
                )
            }
        }
    }

}

