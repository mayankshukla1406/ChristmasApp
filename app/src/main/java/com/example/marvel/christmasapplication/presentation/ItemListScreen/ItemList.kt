package com.example.marvel.christmasapplication.presentation.ItemListScreen

import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.marvel.christmasapplication.R
import com.example.marvel.christmasapplication.util.States
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ItemList(
    navController: NavHostController,
    viewModel: ItemViewModel = hiltViewModel()
) {
    val deviceConfig = LocalConfiguration.current
    val screenWidth = deviceConfig.screenWidthDp
    val lazyState = rememberLazyListState()
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.christmas),
            contentDescription = "itemImage",
        )
        when (val list = viewModel.itemState.value) {
            is States.Loading -> Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            is States.Success -> Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyVerticalGrid(
                    state = lazyState,
                    cells = GridCells.Adaptive(screenWidth.dp.div(2)),
                    contentPadding = PaddingValues(10.dp),
                    content = {
                        items(items = list.data) { item ->
                            Item(item = item, onItemClick = {
                                val encoded = URLEncoder.encode(item.itemImage,StandardCharsets.UTF_8.toString())
                                navController.navigate("ItemDetailScreen"+"/${item.itemName}/${item.itemDescription}/${encoded}")
                            })
                        }
                    }
                )
            }
            is States.Error -> Toast(message = list.message)
        }
    }
}

@Composable
fun Toast(message: String) {
    makeText(LocalContext.current, message, LENGTH_SHORT).show()
}