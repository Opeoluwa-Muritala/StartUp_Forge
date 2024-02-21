package com.example.startup_forge.AppUI.SignInUI

import android.content.Context
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.API.ApiClient
import com.example.startup_forge.EndPoints.Register
import com.example.startup_forge.EndPoints.User
import com.example.startup_forge.MainRoute
import com.example.startup_forge.UIComponents.ButtonState
import com.example.startup_forge.UIComponents.FadingButton
import com.example.startup_forge.UIComponents.ForgotAndRememberPassword
import com.example.startup_forge.UIComponents.HeaderText
import com.example.startup_forge.UIComponents.MiddleSlot
import com.example.startup_forge.UIComponents.OtherOption
import com.example.startup_forge.UIComponents.SignWithGoogle
import com.example.startup_forge.UIComponents.textField
import com.example.startup_forge.UIComponents.textFieldWithIcon
import com.example.startup_forge.R
import com.example.startup_forge.ViewModels.PasswordIconViewModel
import com.example.startup_forge.ViewModels.TextFieldViewModel
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignInUI(navController: NavController) {
    val textfield = remember {
        TextFieldViewModel()
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showIcon = remember {
        PasswordIconViewModel().myData
    }
    var loading by remember {
        mutableStateOf(false)
    }
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
                textField(textFieldState =email , textfieldLabel = "Email", {email = it})

                textFieldWithIcon(
                    textFieldState = password, textfieldLabel = "Password", icons = listOf(
                        R.drawable.eyeopened,
                        R.drawable.eyeclosed
                    ), showIcon = showIcon,
                    {showIcon = !showIcon}
                ) {

                    password = it
                }

                ForgotAndRememberPassword(
                    "Forgot Password?"
                ){}
                MiddleSlot()

                SignWithGoogle(SignInClick = {
                    navController.navigate(MainRoute.BussinesInfo.route)
                    navController.navigate(MainRoute.BussinesInfo.route)
                },)
                Column(
                    modifier = Modifier
                        .width(260.dp)
                        .height(IntrinsicSize.Max),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (!loading) {
                        FadingButton(
                            buttonState = ButtonState(
                                "Sign In",
                                password != "",
                            )
                        ) {
                            loading = true
                        }
                    } else {
                        LaunchedEffect(key1 = loading, ){
                            delay(3000)
                            navController.navigate(MainRoute.BussinesInfo.route)

                            if (email != "" && password != "") {
                                val call = ApiClient.apiService.login(
                                    User(
                                        email,
                                        password
                                    )
                                )
                                call!!.enqueue(object : Callback<User?> {

                                    override fun onResponse(
                                        call: Call<User?>?,
                                        response: Response<User?>
                                    ) {
                                        if (response.isSuccessful) {
                                            Toast.makeText(
                                                context,
                                                "Data posted to API ${response.toString()}",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }else{
                                            Toast.makeText(
                                                context,
                                                "Data not posted to API ${response.toString()}",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            Log.d("response", "$response")
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<User?>?,
                                        t: Throwable
                                    ) {
                                        // we get error response from API.
                                        Toast.makeText(
                                            context,
                                            "Error found is : " + t.message,
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                                )
                            }
                        }
                        CircularProgressIndicator(
                            color = Color.Magenta,
                            strokeWidth = 5.dp,
                            trackColor = Color.LightGray,
                            strokeCap = StrokeCap.Butt
                        )
                    }
                    OtherOption(text = "Sign up" , text1 = "Don't have an account?") {

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