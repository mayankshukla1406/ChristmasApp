package com.example.marvel.christmasapplication.presentation.ItemDetailScreen

import android.content.Intent
import android.net.Uri
import android.widget.Toast.makeText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.marvel.christmasapplication.domain.model.Item
import com.example.marvel.christmasapplication.presentation.Dimension
import com.example.marvel.christmasapplication.ui.theme.newColor

@ExperimentalCoilApi
@Composable
fun ItemDetail(item: Item) {
    val intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://www.amazon.com/Tile-Essentials-Bluetooth-Trackers-Locators/dp/B09B2YYD7W/?_encoding=UTF8&pf_rd_p=693e892e-a787-4902-add9-83da1860da40&pd_rd_wg=PMv6G&pf_rd_r=WJDDWFDVD5Z6HYYDDY1N&pd_rd_w=TNocQ&pd_rd_r=73826e22-c252-439f-b11c-bcf2f2f6c83e&ref_=exports_top_sellers_unrec"))
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().background(color = newColor)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.height(40f).dp)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
        ) {
            Image(painter = rememberImagePainter(data = item.itemImage),
                contentDescription = "Item Image",
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.height(50f).dp)
            .padding(start = 15.dp, top = 10.dp, end = 10.dp)
        ) {
            Text(text = item.itemName,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = item.itemDescription,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic)
        }
        Button(modifier = Modifier.fillMaxWidth().height(Dimension.height(10f).dp), onClick = {
            startActivity(context, intent, null)
        }
        ) {
            Text(text = "Buy Now", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}