package com.oslomet.cognitivetrainingapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oslomet.cognitivetrainingapp.ui.screens.HomeScreen

@Composable
fun AppNavitgation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(modifier,navController)
        }
    }

}