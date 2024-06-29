package com.example.unitconverter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitComposableScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "UnitComposableScreen") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Unit Converter")
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Enter a value") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitComposableScreenPreview() {
    UnitComposableScreen()
}