package com.example.unitconverter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaptainGame() {
    var treasuresFound by remember { mutableStateOf(0) }
    var direction by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "CaptainGame") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Treasures Found: ${treasuresFound}")
            Text(text = "Direction: ${direction}")
            Button(onClick = {
                direction = "East"
                if(Random.nextBoolean()) treasuresFound++
            }) {
                Text(text = "Sail East")
            }
            Button(onClick = {
                direction = "West"
                if(Random.nextBoolean()) treasuresFound++
            }) {
                Text(text = "Sail West")
            }
            Button(onClick = {
                direction = "North"
                if(Random.nextBoolean()) treasuresFound++
            }) {
                Text(text = "Sail North")
            }
            Button(onClick = {
                direction = "South"
                if(Random.nextBoolean()) treasuresFound++
            }) {
                Text(text = "Sail South")
            }
        }
    }
}

@Preview
@Composable
fun CaptainGamePreview() {
    CaptainGame()
}