package com.example.marvel.christmasapplication.presentation.ItemListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.marvel.christmasapplication.domain.model.Item
import com.example.marvel.christmasapplication.presentation.Dimension


@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun Item(
    item:Item,
    onItemClick : (Item) -> Unit
) {
    Card(modifier =
    Modifier
        .fillMaxWidth()
        .height(Dimension.height(value = 40f).dp)
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        .background(Color.White),
        elevation = 20.dp,
        shape = RoundedCornerShape(5.dp),
        onClick = {
            onItemClick(item)
        }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = rememberImagePainter(data = item.itemImage),
                        contentDescription = "itemImage",
                        Modifier.fillMaxHeight(0.5f)
                    )
                    Text(
                        text = item.itemName,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier =
                        Modifier.padding(5.dp).fillMaxWidth()
                    )
                }
            }
        }
    }
}