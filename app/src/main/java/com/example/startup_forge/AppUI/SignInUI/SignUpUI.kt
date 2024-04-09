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
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.startup_forge.data.model.Register
import com.example.startup_forge.data.repository.Repository
import com.example.startup_forge.data.viewmodel.MainViewModel
import com.example.startup_forge.data.viewmodel.MainViewModelFactory
import com.example.startup_forge.Navigation.MainRoute
import com.example.startup_forge.UIComponents.AgreeToTerms
import com.example.startup_forge.UIComponents.ButtonState
import com.example.startup_forge.UIComponents.FadingButton
import com.example.startup_forge.UIComponents.HeaderText
import com.example.startup_forge.UIComponents.MiddleSlot
import com.example.startup_forge.UIComponents.OtherOption
import com.example.startup_forge.UIComponents.SignWithGoogle
import com.example.startup_forge.UIComponents.AppField
import com.example.startup_forge.UIComponents.AppFieldWithIcon
import retrofit2.HttpException
import java.io.IOException
import java.lang.RuntimeException
import java.net.SocketTimeoutException

private lateinit var viewModel: MainViewModel
@Composable
fun SignUpUI(navController: NavController, ) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirm_password by remember {
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
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
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
                AppField(textFieldState = email, textfieldLabel = "Email") { email = it }
                AppFieldWithIcon(
                    textFieldState = password, "Password", showIcon = showIcon, onClickIcon = {
                        showIcon = !showIcon
                    }
                ) { password = it }
                AppFieldWithIcon(
                    textFieldState = confirm_password,
                    "Confirm Password",
                    showIcon = showIcon2,
                    onClickIcon = {
                       showIcon2 = !showIcon2
                    }
                ) { confirm_password = it }
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
                            email != "" && password != "" && confirm_password != "",
                        )
                    ) {
                        loading = true
                        if (password == confirm_password) {
                            try {
                                viewModel.register(Register(email, password))
                                viewModel.registerResponse.observe(
                                    lifecycleOwner
                                ) { response ->
                                    if (response.isSuccessful) {
                                        Log.d("Main", response.body().toString())
                                        Log.d("Main", response.code().toString())
                                        Log.d("Main", response.message())
                                    } else {
                                        Toast.makeText(
                                            context,
                                            response.code(),
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                            } catch (e: IOException) {
                                Log.e("IOException", "Internet not available")
                            } catch (e: HttpException) {
                                Log.e("HttpException", "HttpException ${e.code()}")
                            } catch (e: RuntimeException) {
                                Log.e("RuntimeException", "Runtime Exception")
                            }catch (e: SocketTimeoutException) {
                                Log.e("RuntimeException", "Socket")
                            }
                            navController.navigate(MainRoute.SignIn.route)
                        } else {
                            Toast.makeText(
                                context,
                                "Password and Confirm Password are not the same",
                                Toast.LENGTH_LONG
                            ).show()
                        }
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