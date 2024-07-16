package com.example.unitconverter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val id: Int,
    val name: String,
    val quantity: Int,
    val isEditing: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingList() {

    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "ShoppingList") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
                onClick = { showDialog = true }) {
                Text(text = "Add Item")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                items(sItems) { index ->
                    ShoppingListItem(index, {}, {})
                }

            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    Row(
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Button(onClick = {
                            if (itemName.isNotEmpty() && itemQuantity.isNotEmpty()) {
                                val newItem = ShoppingItem(
                                    id = sItems.size + 1,
                                    name = itemName,
                                    quantity = itemQuantity.toInt(),
                                )
                                sItems = sItems + newItem
                                showDialog = false
                                itemName = ""
                                itemQuantity = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                        Button(onClick = { showDialog = false }) {
                            Text(text = "Cancel")
                        }
                    }
                },
                title = { Text(text = "Add Shopping Item") },
                text = {
                    Column {
                        OutlinedTextField(
                            value = itemName,
                            onValueChange = {
                                itemName = it
                            },
                            label = { Text(text = "Item Name") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        )
                        OutlinedTextField(
                            value = itemQuantity,
                            onValueChange = {
                                itemQuantity = it
                            },
                            label = { Text(text = "Quantity") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.Red),
                shape = RoundedCornerShape(20)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = item.name
        )
        Text(
            modifier = Modifier,
            text = item.quantity.toString()
        )
        Row(
            modifier = Modifier
        ) {
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Outlined.Edit, contentDescription = "")
            }
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Outlined.Delete, contentDescription = "")
            }
        }
    }

}

@Composable
fun ShoppingListEditor(item: ShoppingItem, onEditComplete: (String, Int) -> Unit) {
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(
        modifier = Modifier
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            TextField(
                value = editedName,
                onValueChange = {
                    editedName = it
                },
                singleLine = true,
                label = { Text(text = "Editing Name") },
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            TextField(
                value = editedQuantity,
                onValueChange = {
                    editedQuantity = it
                },
                singleLine = true,
                label = { Text(text = "Editing Quantity") },
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }
        Button(
            onClick = {
                isEditing = false
                onEditComplete(editedName, editedQuantity.toIntOrNull() ?: 1)
            }
        ) {
            Text(text = "Save")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShoppingListPreview() {
    ShoppingList()
}

@Preview(showBackground = true)
@Composable
fun ShoppingListItemPreview() {
    ShoppingListItem(item = ShoppingItem(
        1,
        "Milk",
        2
    ),
        onEditClick = {},
        onDeleteClick = {})
}

@Preview(showBackground = true)
@Composable
fun ShoppingListEditorPreview() {
    ShoppingListEditor(item = ShoppingItem(
        1,
        "Milk",
        2
    ),
        onEditComplete = { _, _ -> })
}