package com.example.startup_forge.AppUI.SignInUI

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.Navigation.MainRoute
import com.example.startup_forge.UIComponents.AppField
import com.example.startup_forge.UIComponents.AppFieldWithIcon
import com.example.startup_forge.UIComponents.ButtonState
import com.example.startup_forge.UIComponents.FadingButton
import com.example.startup_forge.UIComponents.ForgotAndRememberPassword
import com.example.startup_forge.UIComponents.HeaderText
import com.example.startup_forge.UIComponents.MiddleSlot
import com.example.startup_forge.UIComponents.OtherOption
import com.example.startup_forge.data.model.User
import com.example.startup_forge.data.repository.Repository
import com.example.startup_forge.data.viewmodel.MainViewModel
import com.example.startup_forge.data.viewmodel.MainViewModelFactory


private lateinit var viewModel: MainViewModel
data class SignInState(
    val email: MutableState<String> = mutableStateOf(""),
    val password: MutableState<String> = mutableStateOf(""),
    val showIcon: Boolean = false,
    val loading: Boolean = false
)
@Composable
fun SignInUI(navController: NavController) {
    var uiState by remember {
        mutableStateOf(SignInState())
    }
    val repository = Repository()
    val viewModelFactory = MainViewModelFactory(repository)
    viewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = viewModelFactory)
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current


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
            HeaderText(text = "Welcome Back!")
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppField(textFieldState = uiState.email, textfieldLabel = "Email")

                AppFieldWithIcon(
                    textFieldState = uiState.password,
                    "Password",
                    showIcon = uiState.showIcon
                ) { uiState = uiState.copy(showIcon = !uiState.showIcon) }

                ForgotAndRememberPassword(
                    "Forgot Password?"
                ) {}
                MiddleSlot()

                Column(
                    modifier = Modifier
                        .width(260.dp)
                        .height(IntrinsicSize.Max),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    FadingButton(
                        buttonState = ButtonState(
                            "Sign In",
                            uiState.password.value != "",
                        )
                    ) {
                        uiState = uiState.copy(loading = true)
                        viewModel.login(
                            User(
                                email = uiState.email.value,
                                password = uiState.password.value
                            )
                        )
                        viewModel.loginResponse.observe(lifecycleOwner){
                            Log.d("Register", it.message() + it.code() + it.body())
                            Toast.makeText(
                                context,
                                it.message() + it.code() + it.body(),
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                    OtherOption(text = "Sign up", text1 = "Don't have an account?") {
                        navController.navigate(MainRoute.SignUp.route)
                    }
                }
            }
        }
    }
}




@Preview
@Composable
fun SignIn(){
    SignInUI(rememberNavController())
}