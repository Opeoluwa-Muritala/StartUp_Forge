package com.example.startup_forge

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.AppUI.BottomNavigation.BottomMenu
import com.example.startup_forge.AppUI.Community.Community
import com.example.startup_forge.AppUI.CreateProfile.Component.Experience
import com.example.startup_forge.AppUI.SignInUI.BusinessInfo
import com.example.startup_forge.AppUI.SignInUI.SignInUI
import com.example.startup_forge.AppUI.SignInUI.SignUpUI
import com.example.startup_forge.Navigation.AppRoute
import com.example.startup_forge.Navigation.MainRoute
import com.example.startup_forge.Navigation.Nav
import com.example.startup_forge.ui.theme.StartUp_ForgeTheme
import com.example.startup_forge.ui.theme.TextGray

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartUp_ForgeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = TextGray
                ) {
                    Nav()

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StartUp_ForgeTheme {

    }
}