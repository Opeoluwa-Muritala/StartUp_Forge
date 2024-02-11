package com.example.startup_forge.AppUI.BottomNavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.startup_forge.ui.theme.TextBlack
import com.example.startup_forge.ui.theme.ThemeOrange

@Composable
fun BottomMenu(navController: NavController){
    var selectedItemIndex by remember {
        mutableIntStateOf(2)
    }

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Transparent
    ) {
        BottomNavItems().forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = index == selectedItemIndex,
                label = {
                    Text(bottomNavItem.title, fontSize = 9.sp)
                },
                icon = {
                    Icon(
                        painter = painterResource(bottomNavItem.iconId),
                        contentDescription = bottomNavItem.title,
                        modifier = Modifier.size(30.dp)
                    )
                },
                onClick = {
                    selectedItemIndex =  index
                    navController.navigate(bottomNavItem.route){
                        launchSingleTop =true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor= ThemeOrange,
                    selectedTextColor= ThemeOrange,
                    unselectedIconColor= Color.DarkGray,
                    unselectedTextColor= TextBlack,
                    indicatorColor = Color.Transparent
                )
            )

        }
    }
}




