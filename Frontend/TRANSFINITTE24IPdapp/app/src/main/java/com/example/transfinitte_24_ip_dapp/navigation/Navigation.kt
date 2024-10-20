package com.example.transfinitte_24_ip_dapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.transfinitte_24_ip_dapp.MainViewModel
import com.example.transfinitte_24_ip_dapp.screens.LandingPage
import com.example.transfinitte_24_ip_dapp.screens.RegisterPage
import com.example.transfinitte_24_ip_dapp.screens.TransferPage

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel<MainViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screens.LandingPage.route
    ) {
        composable(route = Screens.LandingPage.route) {
            LandingPage(navController)
        }

        composable(route = Screens.RegisterPage.route) {
            RegisterPage(navController)
        }

        composable(route = Screens.TransferPage.route) {
            TransferPage(navController)
        }
    }
}