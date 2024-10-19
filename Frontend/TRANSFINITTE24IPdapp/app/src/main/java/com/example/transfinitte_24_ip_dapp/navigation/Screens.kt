package com.example.transfinitte_24_ip_dapp.navigation

sealed class Screens(val route: String) {
    data object LandingPage : Screens("LandingPage")
}