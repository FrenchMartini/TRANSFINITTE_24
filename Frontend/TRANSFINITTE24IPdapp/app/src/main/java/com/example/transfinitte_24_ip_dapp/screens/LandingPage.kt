package com.example.transfinitte_24_ip_dapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.transfinitte_24_ip_dapp.navigation.Screens
import com.example.transfinitte_24_ip_dapp.ui.theme.alumniSans
import com.example.transfinitte_24_ip_dapp.ui.theme.anticRegular


@Composable
fun LandingPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.fillMaxSize(0.05f))
        Text(
            "Dashboard",
            fontSize = 58.sp,
            color = Color.White,
            fontFamily = alumniSans
        )
        Text(
            "Unified IP Portal",
            fontSize = 20.sp,
            color = Color.LightGray,
            fontFamily = alumniSans,
            letterSpacing = TextUnit(3.5f, TextUnitType.Sp)

        )
        Spacer(modifier = Modifier.fillMaxSize(0.05f))
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.7f),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .horizontalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Search Patents",
                    color = Color.Yellow,
                    fontSize = 20.sp,
                    fontFamily = anticRegular
                )
                var field1 by remember { mutableStateOf("") }
                Spacer(modifier = Modifier.fillMaxSize(0.05f))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(0.7f),
                        value = field1,
                        onValueChange = { field1 = it }, // Handles the text changes
                        textStyle = TextStyle(color = Color.White),
                        label = { Text("Title of Patent") }
                    )
                }

                var field2 by remember { mutableStateOf("") }
                Spacer(modifier = Modifier.fillMaxSize(0.05f))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(0.7f),
                        value = field2,
                        onValueChange = { field2 = it }, // Handles the text changes
                        textStyle = TextStyle(color = Color.White),
                        label = { Text("Name of Author") }
                    )
                }

                var field3 by remember { mutableStateOf("") }
                Spacer(modifier = Modifier.fillMaxSize(0.05f))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(0.7f),
                        value = field3,
                        onValueChange = { field3 = it }, // Handles the text changes
                        textStyle = TextStyle(color = Color.White),
                        label = { Text("Search from abstract/content") }
                    )
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(110.dp)
                        .padding(vertical = 20.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                    ),
                ) {
                    Text(
                        "Search",
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = anticRegular
                    )
                }

                LazyColumnWithTwoTextBoxes()
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        Row {
            Button(
                onClick = {
                    navController.navigate(Screens.RegisterPage.route)
                },
                modifier = Modifier.width(110.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
            ) {
                Text(
                    "Register Patent",
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = anticRegular
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                onClick = {
                    navController.navigate(Screens.TransferPage.route)
                },
                modifier = Modifier.width(110.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
            ) {
                Text(
                    "Transfer Patent",
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = anticRegular
                )
            }

        }
    }
}

@Composable
fun LazyColumnWithTwoTextBoxes() {
    val fields = listOf("Item 1", "Item 2", "Item 3", "Item 4") // Sample data

    LazyColumn(
        modifier = Modifier.fillMaxSize(0.9f)
    ) {
        items(fields) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Spacer(modifier = Modifier.weight(1f)) // Adjusted to use weight

                Text(
                    text = item,
                    modifier = Modifier.weight(1f), // Use weight to ensure space is distributed
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(10.dp)) // Adjusted to use weight
                Text(
                    text = "Right",
                    modifier = Modifier.weight(1f), // Use weight to ensure space is distributed
                    color = Color.White
                )
            }
        }
    }
}


@Preview
@Composable
private fun LandingPrev() {
    LandingPage(rememberNavController())
}