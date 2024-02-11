package com.example.startup_forge.AppUI.BottomNavigation

import androidx.annotation.DrawableRes
import com.example.startup_forge.AppRoute
import com.example.startup_forge.R

data class BottomNavItem(
    val title: String,
    @DrawableRes val iconId:Int,
    val route: String
)
    fun BottomNavItems(): List<BottomNavItem>{
        return listOf(
            BottomNavItem("Home", R.drawable.eyeopened, AppRoute.Home.route),
            BottomNavItem("Mentor", R.drawable.eyeclosed, AppRoute.Mentor.route),
            BottomNavItem("Community", R.drawable.eyeopened , AppRoute.Community.route),
            BottomNavItem("Booking", R.drawable.eyeclosed, AppRoute.Booking.route),
        )
    }

