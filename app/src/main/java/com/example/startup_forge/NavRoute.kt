package com.example.startup_forge

sealed class MainRoute(val route: String){
    object SignUp : MainRoute("sign_up")
    object SignIn : MainRoute("sign_in")
    object BussinesInfo : MainRoute("more_info")
    object MainApp : MainRoute("main_app")
}

sealed class AppRoute(val route: String){
    object Home: AppRoute("home")
    object Mentor: AppRoute("mentor")
    object Community: AppRoute("community")
    object Booking: AppRoute("booking")
}