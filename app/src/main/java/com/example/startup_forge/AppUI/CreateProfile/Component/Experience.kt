package com.example.startup_forge.AppUI.CreateProfile.Component

import android.os.Build
import android.util.MonthDisplayHelper
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.startup_forge.UIComponents.DropDownTextField
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Experience(
    text: MutableState<String>,
    show: Boolean,
    onClick: () -> Unit,
    text2: MutableState<String>,
    show2: Boolean,
    onClick2: () -> Unit
) {
    val months = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    val years = listOf<Any>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, "30+")
    Column(
        Modifier.fillMaxSize().padding(horizontal = 10.dp)
    ) {
        Text("How Many Years Of Experience Do You Have?")
        Row(
            Modifier.fillMaxSize().padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DropDownTextField(
                label = "Years",
                onDropCLick = { onClick() },
                show = show,
                text = text,
                list = years,
                modifier = Modifier.width(150.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            DropDownTextField(
                label = "Month",
                onDropCLick = { onClick2() },
                show = show2,
                text = text2,
                list = months,
                modifier = Modifier.width(150.dp)
            )
        }
    }

}