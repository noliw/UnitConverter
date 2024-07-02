package com.example.unitconverter

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            VerticalSpacer(size = 16)
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Enter a value") }
            )
            VerticalSpacer(size = 16)
            Row {
                Box {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Select"
                        )
                    }
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(
                            text = {
                                Text("cm")
                            },
                            onClick = { /*TODO*/ })
                        DropdownMenuItem(
                            text = {
                                Text("m")
                            },
                            onClick = { /*TODO*/ })
                        DropdownMenuItem(
                            text = {
                                Text("ft")
                            },
                            onClick = { /*TODO*/ })
                        DropdownMenuItem(
                            text = {
                                Text("mm")
                            },
                            onClick = { /*TODO*/ })
                    }
                }
                HorizontalSpacer(size = 16)
                Box {
                    Button(onClick = { /*todo*/ }) {
                        Text(text = "Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Select"
                        )
                    }
                    DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(
                            text = {
                                Text("cm")
                            },
                            onClick = { /*TODO*/ })
                        DropdownMenuItem(
                            text = {
                                Text("m")
                            },
                            onClick = { /*TODO*/ })
                        DropdownMenuItem(
                            text = {
                                Text("ft")
                            },
                            onClick = { /*TODO*/ })
                        DropdownMenuItem(
                            text = {
                                Text("mm")
                            },
                            onClick = { /*TODO*/ })
                    }


                }
            }
            VerticalSpacer(size = 16)
            Text(text = "Result")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitComposableScreenPreview() {
    UnitComposableScreen()
}

@Composable
fun HorizontalSpacer(size: Int) = Spacer(modifier = Modifier.width(size.dp))

@Composable
fun VerticalSpacer(size: Int) = Spacer(modifier = Modifier.height(size.dp))