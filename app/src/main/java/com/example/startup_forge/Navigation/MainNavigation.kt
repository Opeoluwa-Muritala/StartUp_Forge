package com.example.startup_forge.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.AppUI.SignInUI.BusinessInfo
import com.example.startup_forge.AppUI.SignInUI.SignInUI
import com.example.startup_forge.AppUI.SignInUI.SignUpUI

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainRoute.SignUp.route){
        composable(
            MainRoute.SignUp.route,
        ){
            SignUpUI(navController)
        }
        composable(MainRoute.SignIn.route){
            SignInUI(navController)
        }
        composable(MainRoute.BussinesInfo.route){
            BusinessInfo(navController)
        }
        composable(MainRoute.MainApp.route){
            InAppNavigation()
        }
    }
}