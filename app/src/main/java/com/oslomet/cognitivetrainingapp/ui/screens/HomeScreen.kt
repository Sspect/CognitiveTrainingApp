package com.oslomet.cognitivetrainingapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.oslomet.cognitivetrainingapp.ui.pages.GamesPage
import com.oslomet.cognitivetrainingapp.ui.pages.SettingsPage
import com.oslomet.cognitivetrainingapp.ui.pages.UserPage

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    val navItemList = listOf(
        NavItem("Games", Icons.Default.Star),
        NavItem("User", Icons.Default.AccountCircle),
        NavItem("Settings", Icons.Default.Settings),
    )
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = index==selectedIndex,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = navItem.lable)
                        },
                        label = {
                            Text(text = navItem.lable)
                        },
                    )
                }
            }
        }
    ) {
        Pages(modifier = modifier.padding(it),navController,selectedIndex)
    }
}

@Composable
fun Pages(modifier: Modifier = Modifier,navController: NavHostController,selectedIndex : Int) {
    when(selectedIndex){
        0-> GamesPage(modifier)
        1-> UserPage(modifier)
        2-> SettingsPage(modifier)
    }

}


data class NavItem(
    val lable : String,
    val icon : ImageVector,
)