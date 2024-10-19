package com.example.transfinitte_24_ip_dapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.transfinitte_24_ip_dapp.MainViewModel
import com.example.transfinitte_24_ip_dapp.screens.LandingPage
import com.example.transfinitte_24_ip_dapp.screens.RegisterPage

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel<MainViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screens.LandingPage.route
    ) {
        composable(route = Screens.LandingPage.route) {
            LandingPage()
        }

        composable(route = Screens.RegisterPage.route) {
            RegisterPage()
        }
    }
}