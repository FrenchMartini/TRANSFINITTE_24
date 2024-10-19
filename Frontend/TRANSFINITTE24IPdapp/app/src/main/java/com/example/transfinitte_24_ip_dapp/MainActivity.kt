package com.example.transfinitte_24_ip_dapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.transfinitte_24_ip_dapp.ui.theme.TRANSFINITTE24IPdappTheme
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

class MainActivity : ComponentActivity() {

//    private lateinit var web3j: Web3j

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        web3j = Web3j.build(HttpService("https://sepolia.infura.io/v3/563f3d565c694d9983e98b8eeb70b62d"))
        enableEdgeToEdge()
        setContent {
            TRANSFINITTE24IPdappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TRANSFINITTE24IPdappTheme {
        Greeting("Android")
    }
}