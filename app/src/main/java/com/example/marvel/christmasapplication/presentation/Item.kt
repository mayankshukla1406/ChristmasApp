package com.example.marvel.christmasapplication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.marvel.christmasapplication.domain.model.Item


@Composable
fun Item(
    item:Item
) {
    Card(modifier =
    Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        .background(Color.White),
        elevation = 20.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.itemName,
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}