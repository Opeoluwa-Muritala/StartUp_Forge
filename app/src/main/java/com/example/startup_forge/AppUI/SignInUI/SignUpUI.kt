package com.example.startup_forge.AppUI.SignInUI

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.startup_forge.Navigation.MainRoute
import com.example.startup_forge.UIComponents.AgreeToTerms
import com.example.startup_forge.UIComponents.AppField
import com.example.startup_forge.UIComponents.AppFieldWithIcon
import com.example.startup_forge.UIComponents.ButtonState
import com.example.startup_forge.UIComponents.FadingButton
import com.example.startup_forge.UIComponents.HeaderText
import com.example.startup_forge.UIComponents.MiddleSlot
import com.example.startup_forge.UIComponents.OtherOption
import com.example.startup_forge.data.model.Register
import com.example.startup_forge.data.repository.Repository
import com.example.startup_forge.data.viewmodel.MainViewModel
import com.example.startup_forge.data.viewmodel.MainViewModelFactory


private lateinit var viewModel: MainViewModel
@Composable
fun SignUpUI(navController: NavController) {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val confirm_password = remember {
        mutableStateOf("")
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    var showIcon2 by remember {
        mutableStateOf(false)
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val repository = Repository()
    val viewModelFactory = MainViewModelFactory(repository)
    viewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = viewModelFactory)




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
            HeaderText(text = "Create Account")
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppField(textFieldState = email, textfieldLabel = "Email")
                AppFieldWithIcon(
                    textFieldState = password, "Password", showIcon = showIcon, onClickIcon = {
                        showIcon = !showIcon
                    }
                )
                AppFieldWithIcon(
                    textFieldState = confirm_password,
                    "Confirm Password",
                    showIcon = showIcon2,
                    onClickIcon = {
                       showIcon2 = !showIcon2
                    }
                )
                AgreeToTerms()
                MiddleSlot()


                Column(
                    modifier = Modifier
                        .width(260.dp)
                        .height(IntrinsicSize.Max),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    FadingButton(
                        buttonState = ButtonState(
                            "Sign Up",
                            email.value != "" && password.value != "" && confirm_password.value != "",
                        )
                    ) {
                        loading = true
                        viewModel.register(
                            Register(
                            email = email.value,
                            password = password.value
                        )
                        )
                        Log.d("Register", viewModel.registerResponse.toString())
                    }


                        OtherOption(text = "Sign in") {
                            navController.navigate(MainRoute.SignIn.route)
                        }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUp(){
}