import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import coil.annotation.ExperimentalCoilApi
import com.example.marvel.christmasapplication.presentation.ItemListScreen.ItemList
import com.example.marvel.christmasapplication.presentation.BottomNavigationBar.NavigationItems
import com.example.marvel.christmasapplication.presentation.ItemDetailScreen.ItemDetail


@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            NavigationBottomView(
                items = listOf(
                    NavigationItems("Home", "Home", Icons.Default.Home),
                    NavigationItems("Profile", "Profile", Icons.Default.Contacts),
                    NavigationItems("FAQ", "FAQ", Icons.Default.Settings),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        }
    ) {
        Navigation(navController = navController)
    }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController =navController,startDestination = "ItemListScreen"){
        composable("ItemListScreen"){
            ItemList(navController = navController)
        }
        composable("Profile"){
            Profile()
        }
        composable("FAQ"){
            FAQ()
        }
    }
}
@Composable
@ExperimentalMaterialApi
fun NavigationBottomView(
    items : List<NavigationItems>,
    modifier: Modifier = Modifier,
    navController: NavController,
    onItemClick : (NavigationItems) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.White, elevation = 5.dp) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected, onClick = { onItemClick(item) },
                selectedContentColor = Color.Red, unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                        if (selected) {
                            Text(text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            )
        }
    }
}
@Composable
fun Home(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text="Home Screen")
    }
}
@Composable
fun Profile(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text="Settings Screen")
    }
}
@Composable
fun FAQ(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text="Chat Screen")
    }
}