package com.example.transfinitte_24_ip_dapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.transfinitte_24_ip_dapp.ui.theme.alumniSans

@Composable
fun RegisterPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxSize(0.05f))
        Text(
            text = "Register Patent",
            color = Color.White,
            fontSize = 58.sp,
            fontFamily = alumniSans
        )
        Spacer(modifier = Modifier.fillMaxSize(0.05f))
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(.7f),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Title",
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Abstract",
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Register", fontSize = 20.sp)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Back", fontSize = 20.sp)
            }
        }
    }
}

@Preview
@Composable
private fun RegisterPrev() {
    RegisterPage(rememberNavController())
}