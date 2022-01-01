package com.example.marvel.christmasapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.marvel.christmasapplication.domain.model.Item
import com.example.marvel.christmasapplication.presentation.ItemDetailScreen.ItemDetail
import com.example.marvel.christmasapplication.presentation.ItemListScreen.ItemList
import com.example.marvel.christmasapplication.ui.theme.ChristmasApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChristmasApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "ItemListScreen"
                    ) {
                        composable(
                            route = "ItemListScreen"
                        ) {
                            ItemList(navController)
                        }
                        composable(
                            route = "ItemDetailScreen/{itemName}/{itemDescription}/{itemImage}",
                            arguments = listOf(
                                navArgument("itemName"){
                                    type= NavType.StringType
                                },
                                navArgument("itemDescription"){
                                    type = NavType.StringType
                                },
                                navArgument("itemImage"){
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val itemName = it.arguments?.get("itemName").toString()
                            val itemDescription = it.arguments?.get("itemDescription").toString()
                            val itemImage = it.arguments?.get("itemImage").toString()
                            val obj = Item(itemName = itemName, itemDescription = itemDescription, itemImage = itemImage)
                            ItemDetail(obj)
                        }
                    }
                }
            }
        }
    }
}