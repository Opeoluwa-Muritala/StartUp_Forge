package com.example.startup_forge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.AppUI.BottomNavigation.BottomMenu
import com.example.startup_forge.AppUI.Community.Community
import com.example.startup_forge.AppUI.SignInUI.BussinessInfo
import com.example.startup_forge.AppUI.SignInUI.SignInUI
import com.example.startup_forge.AppUI.SignInUI.SignUpUI
import com.example.startup_forge.ui.theme.StartUp_ForgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartUp_ForgeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigation()

                }
            }
        }
    }

}
@Composable
fun InAppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) {
        Column(
            Modifier.padding(it)
        ) {
            NavHost(navController = navController, startDestination = AppRoute.Community.route) {
                composable(AppRoute.Home.route) {
                    Text(text = "Home")
                }
                composable(AppRoute.Community.route) {
                    Community()

                }
                composable(AppRoute.Mentor.route) {
                    Text(text = "Mentor")
                }
                composable(AppRoute.Booking.route) {
                    Text(text = "Booking")
                }
            }
        }
    }
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainRoute.SignUp.route){
        composable(MainRoute.SignUp.route,
        ){
            SignUpUI(navController)
        }
        composable(MainRoute.SignIn.route){
            SignInUI(navController)
        }
        composable(MainRoute.BussinesInfo.route){
            BussinessInfo(navController)
        }
        composable(MainRoute.MainApp.route){
            InAppNavigation()
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StartUp_ForgeTheme {

    }
}