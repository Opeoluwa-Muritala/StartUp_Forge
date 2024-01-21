package com.example.startup_forge.SignInUI

import android.icu.text.IDNA.Info
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.startup_forge.Components.ButtonState
import com.example.startup_forge.Components.FadingButton
import com.example.startup_forge.Components.HeaderText
import com.example.startup_forge.Components.textField

@Composable
fun BussinessInfo() {
    var loading by remember {
        mutableStateOf(false)
    }
    val name = remember {
        mutableStateOf("")
    }
    val location = remember {
        mutableStateOf("")
    }
    val about = remember {
        mutableStateOf("")
    }
    val industry = remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {

        Column(
            modifier = Modifier
                .width(327.dp)
                .height(570.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            HeaderText(text = "Let's Know You!")
            textField(textFieldState = name, textfieldLabel = "Bussiness Name")
            textField(textFieldState = industry, textfieldLabel = "Industry")
            textField(textFieldState = about, textfieldLabel = "About")
            textField(textFieldState = location, textfieldLabel = "Location")

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            FadingButton(
                buttonState = ButtonState(
                    "Sign In",
                    name.value != "" && industry.value != "" && about.value != ""&& location.value != "",
                )
            ) {
                loading = true
            }
            }
        }


    }
}

@Preview
@Composable
fun InfoPreview() {
    BussinessInfo()
}