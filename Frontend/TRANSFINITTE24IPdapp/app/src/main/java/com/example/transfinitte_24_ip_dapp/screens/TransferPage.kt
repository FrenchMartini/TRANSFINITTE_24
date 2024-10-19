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
import com.example.transfinitte_24_ip_dapp.ui.theme.alumniSans


@Composable
fun TransferPage(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.fillMaxSize(0.05f))
        Text(
            text = "Transfer Patent",
            color = Color.White,
            fontSize = 58.sp,
            fontFamily = alumniSans
        )
        Spacer(modifier = Modifier.fillMaxSize(0.05f))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(.7f)
                .padding(vertical = 5.dp),
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

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "Transfer", fontSize = 20.sp)
        }

    }
}

@Preview
@Composable
private fun TransferPrev() {
    TransferPage()
}