package com.example.startup_forge.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AgreeToTerms() {
    var check by remember {
        mutableStateOf(true)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = check, onCheckedChange = {
            check = !check
        }, colors = CheckboxDefaults.colors(
            checkedColor= Color(0xFFFF5722),
            uncheckedColor = Color.LightGray,
            checkmarkColor = Color.White,
        ))
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = buildAnnotatedString {
            append("Agree To All Terms and Conditions")
            addStyle(
                SpanStyle(
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFF5722),

                    ),
                13,
                18
            )
            addStyle(
                SpanStyle(
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFF5722),

                    ),
                22,
                33
            )
        },style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF333333),

            textAlign = TextAlign.Center,
            letterSpacing = 0.42.sp,
        )
            )
    }
}


@Composable
fun OtherOption(
    text:String,
    text1: String = "Already have an account?",
    onTextClick: () -> Unit
) {
    Row {

        Text(
            text = text1,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFFF5722),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.clickable {
                onTextClick()
            }
        )
    }
}

@Composable
fun ForgotAndRememberPassword(
    text:String,
    onTextClick: () -> Unit
) {
    var check by remember {
        mutableStateOf(true)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,){
        Checkbox(
            checked = check, onCheckedChange = {
                check = !check
            }, colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFFF5722),
                uncheckedColor = Color.LightGray,
                checkmarkColor = Color.White,
            )
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = "Remember Password",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
    }

        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFFF5722),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.clickable {
                onTextClick()
            }
        )
    }
}