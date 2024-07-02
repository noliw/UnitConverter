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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitComposableScreen() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor by remember { mutableStateOf(0.01) }
    var oConversionFactor by remember { mutableStateOf(1.0) }

    fun convert() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * conversionFactor * 100 / oConversionFactor).roundToInt() / 100.0
        outputValue = result.toString()
    }
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
            Text(text = "Unit Converter",
                style = MaterialTheme.typography.headlineLarge)
            VerticalSpacer(size = 16)
            OutlinedTextField(
                value = inputValue,
                onValueChange = {
                    inputValue = it
                },
//                placeholder = { Text(text = "Enter a value") },
                label = { Text(text = "Enter a value") }
            )
            VerticalSpacer(size = 16)
            Row {
                Box {
                    Button(onClick = {
                        iExpanded = true
                    }) {
                        Text(text = "Input Unit")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Input Unit"
                        )
                    }
                    DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                        DropdownMenuItem(
                            text = {
                                Text("centimeters")
                            },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Centimeters"
                                conversionFactor = 0.01
                                convert()
                            })
                        DropdownMenuItem(
                            text = {
                                Text("meters")
                            },
                            onClick = {
                                iExpanded = false
                                inputUnit = "meters"
                                conversionFactor = 1.0
                                convert()
                            })
                        DropdownMenuItem(
                            text = {
                                Text("ft")
                            },
                            onClick = {
                                iExpanded = false
                                inputUnit = "feet"
                                conversionFactor = 0.3048
                                convert()
                            })
                        DropdownMenuItem(
                            text = {
                                Text("millimeters")
                            },
                            onClick = {
                                iExpanded = false
                                inputUnit = "millimeters"
                                conversionFactor = 0.001
                                convert()
                            })
                    }
                }
                HorizontalSpacer(size = 16)
                Box {
                    Button(onClick = { oExpanded = true }) {
                        Text(text = "Output Unit")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Select"
                        )
                    }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                        DropdownMenuItem(
                            text = {
                                Text("centimeters")
                            },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Centimeters"
                                oConversionFactor = 0.01
                                convert()
                            })
                        DropdownMenuItem(
                            text = {
                                Text("meters")
                            },
                            onClick = {
                                oExpanded = false
                                outputUnit = "meters"
                                oConversionFactor = 1.0
                                convert()
                            })
                        DropdownMenuItem(
                            text = {
                                Text("feet")
                            },
                            onClick = {
                                oExpanded = false
                                outputUnit = "feet"
                                oConversionFactor = 0.3048
                                convert()
                            })
                        DropdownMenuItem(
                            text = {
                                Text("millimeters")
                            },
                            onClick = {
                                oExpanded = false
                                outputUnit = "millimeters"
                                oConversionFactor = 0.001
                                convert()
                            })
                    }


                }
            }
            VerticalSpacer(size = 16)

            if (inputValue.isNotEmpty()) {
                Text(
                    text = "Result: $outputValue $outputUnit",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

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