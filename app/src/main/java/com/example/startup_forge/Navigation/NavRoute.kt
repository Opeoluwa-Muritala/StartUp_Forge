package com.example.startup_forge.Navigation

sealed class MainRoute(val route: String){
    data object SignUp : MainRoute("sign_up")
    data object SignIn : MainRoute("sign_in")
    data object BusinesInfo : MainRoute("more_info")
    data object MainApp : MainRoute("main_app")
}

sealed class AppRoute(val route: String){
    data object Home: AppRoute("home")
    data object Mentor: AppRoute("mentor")
    data object Community: AppRoute("community")
    data object Booking: AppRoute("booking")
}