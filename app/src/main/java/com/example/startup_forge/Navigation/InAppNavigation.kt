package com.example.startup_forge.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startup_forge.AppUI.BottomNavigation.BottomMenu
import com.example.startup_forge.AppUI.Community.Community


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
