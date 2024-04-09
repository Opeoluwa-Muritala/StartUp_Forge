package com.example.startup_forge.AppUI.BottomNavigation

import androidx.annotation.DrawableRes
import com.example.startup_forge.Navigation.AppRoute
import com.example.startup_forge.R

data class BottomNavItem(
    val title: String,
    @DrawableRes val iconId:Int,
    @DrawableRes val selectedIcon:Int,
    val route: String
)
    fun BottomNavItems(): List<BottomNavItem>{
        return listOf(
            BottomNavItem("Home", R.drawable.home,R.drawable.selectedhome , AppRoute.Home.route),
            BottomNavItem("Mentor", R.drawable.mentor,R.drawable.selectedmentor , AppRoute.Mentor.route),
            BottomNavItem("Community", R.drawable.community ,R.drawable.selectedcommunity ,
                AppRoute.Community.route),
            BottomNavItem("Booking", R.drawable.booking,R.drawable.selectedbooking, AppRoute.Booking.route),
        )
    }

