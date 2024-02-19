package com.example.wasteup.ui.theme.Profile

import android.text.BoringLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startup_forge.UIComponents.SelectionBox
import com.example.startup_forge.UIComponents.textField
import com.example.startup_forge.ViewModels.TextFieldViewModel
import com.example.startup_forge.ui.theme.TextBlack
import com.example.startup_forge.ui.theme.TextGray
import com.example.startup_forge.ui.theme.ThemeOrange

@Composable
fun CreateProfile(

) {

    val viewModel = remember{TextFieldViewModel()}

    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            Icons.Outlined.ArrowBack,
            "BackSpace"
        )

        //Upload Image Section
        Row {
            Box(
                Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) 
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = "Upload Image",
                    fontWeight = Bold,
                    fontSize = 15.sp,
                    color = ThemeOrange
                )
                Text(
                    text = "Make sure the file is below 2MB",
                    fontWeight = Normal,
                    fontSize = 10.sp,
                    color = TextGray
                )
            }
        }

        //Number Of Years Of Experience
        Column {
            Text(
                text = "How Many Years Of Experience Do You Have?",
                fontSize = 15.sp,
                color = TextBlack
            )
            Row {
                SelectionBox(label = "Years", )
                SelectionBox(label = "Months")
            }
        }

        //Linkedin
        Column {
            Text(
                text = "Linkedin",
                fontWeight = Bold,
                fontSize = 15.sp,
                color = TextBlack
            )
            textField(textFieldState = viewModel.myData, textfieldLabel = "Linkedin.com/in/...")
            Text(
                text = "Linkedin url is required",
                fontWeight = Normal,
                fontSize = 10.sp,
                color = ThemeOrange
            )
        }
            //Select Expertise
        Column {
            Text(
                text = "Select Expertise",
                fontWeight = Bold,
                fontSize = 15.sp,
                color = TextBlack
            )
            SelectionBox(label = "E.g: Branding, Marketing")
            Button(


                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.border(
                    2.dp,
                    TextBlack,
                    RoundedCornerShape(20.dp)
                )
            ) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add Other Expertise")
                Text("Add Other Expertise", color = TextBlack, fontSize = 15.sp)
            }
      }

        //Skills
        Column {
            Text(
                text = "Which skills do you have experience in?" ,
                fontWeight = Bold,
                fontSize = 15.sp,
                color = TextBlack
            )
            SelectionBox(label = "Eg: Leadership, Communication")
        }

        //Bio
        Column {
            Text(
                text = "Bio" ,
                fontWeight = Bold,
                fontSize = 15.sp,
                color = TextBlack
            )
            TextField(value = "", onValueChange = {}, modifier = Modifier.heightIn(min= 600.dp))
        }


    }
}