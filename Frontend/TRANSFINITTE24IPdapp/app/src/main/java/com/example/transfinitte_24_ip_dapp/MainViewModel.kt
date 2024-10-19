package com.example.transfinitte_24_ip_dapp

import dagger.hilt.android.lifecycle.HiltViewModel
import org.web3j.protocol.Web3j
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val web3j: Web3j
) {

}