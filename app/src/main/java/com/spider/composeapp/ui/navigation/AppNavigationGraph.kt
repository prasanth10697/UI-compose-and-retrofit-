package com.spider.composeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spider.composeapp.ui.screen.HomeScreen

@Composable
fun AppNavigationGraph(){

    val navController = rememberNavController()
    NavHost (navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeScreen()
        }
    }

}