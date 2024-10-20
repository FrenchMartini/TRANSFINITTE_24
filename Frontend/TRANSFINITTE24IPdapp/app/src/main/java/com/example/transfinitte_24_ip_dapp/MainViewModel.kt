package com.example.transfinitte_24_ip_dapp

import androidx.lifecycle.ViewModel
import com.example.transfinitte_24_ip_dapp.backend.Web3PatentClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val web3PatentClient: Web3PatentClient
): ViewModel() {

}