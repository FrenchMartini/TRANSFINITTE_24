package com.example.transfinitte_24_ip_dapp.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.transfinitte_24_ip_dapp.navigation.Screens
import com.example.transfinitte_24_ip_dapp.ui.theme.alumniSans
import com.example.transfinitte_24_ip_dapp.ui.theme.anticRegular

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
            ),
            border = BorderStroke(1.dp, Color.Yellow),
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var titleField by remember {
                    mutableStateOf("")
                }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(70.dp),
                    value = "Title",
                    onValueChange = {
                        titleField = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedTextColor = Color.LightGray,
                        focusedTextColor = Color.LightGray,
                        focusedSupportingTextColor = Color.LightGray
                    ),
                    placeholder = {
                        Text(
                            text = "Title",
                            color = Color.Gray,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                        )
                    },
                    maxLines = 1,
                    textStyle = TextStyle.Default.copy(fontSize = 30.sp),
                )
            }


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
                onClick = {},
                modifier = Modifier.width(120.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                ),
            ) {
                Text(
                    "Register",
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = anticRegular
                )
            }
            Button(
                onClick = {
                    navController.navigate(Screens.RegisterPage.route)
                },
                modifier = Modifier.width(120.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                ),
            ) {
                Text(
                    "Back",
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = anticRegular
                )
            }
        }
    }
}

@Preview
@Composable
private fun RegisterPrev() {
    RegisterPage(rememberNavController())
}