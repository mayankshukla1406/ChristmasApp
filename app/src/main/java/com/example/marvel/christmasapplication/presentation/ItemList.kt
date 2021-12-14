package com.example.marvel.christmasapplication.presentation

import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvel.christmasapplication.util.States

@Composable
fun ItemList(
    viewModel: ItemViewModel = hiltViewModel()
) {
    when(val list = viewModel.itemState.value) {
        is States.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
        is States.Success -> Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(
                    items = list.data
                ) { item ->
                    Item(
                        item = item
                    )
                }
            }
        }
        is States.Error -> Toast(message = list.message)
    }
}
@Composable
fun Toast(message: String) {
    makeText(LocalContext.current, message, LENGTH_SHORT).show()
}