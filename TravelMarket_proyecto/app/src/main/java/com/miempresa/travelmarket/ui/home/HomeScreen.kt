package com.miempresa.travelmarket.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Commute
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.miempresa.travelmarket.R
import com.miempresa.travelmarket.models.Destino
import com.miempresa.travelmarket.ui.theme.Blue_card
import com.miempresa.travelmarket.ui.theme.GradientEnd
import com.miempresa.travelmarket.ui.theme.GradientStart
import com.miempresa.travelmarket.ui.theme.Green_card
import com.miempresa.travelmarket.ui.theme.Red_card
import com.miempresa.travelmarket.ui.theme.SelectedItemColor
import com.miempresa.travelmarket.ui.theme.UnselectedItemColor
import com.miempresa.travelmarket.ui.theme.Yellow_card

data class Categoria(
    val nombre: String,
    val imageRes: Int,
    val color: Color,
    val icon: ImageVector,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = viewModel()
) {
    val categorias = listOf(
        Categoria("Lugares", R.drawable.lugares, Red_card, Icons.Default.LocationOn, "lugares"),
        Categoria("Eventos", R.drawable.eventos, Blue_card, Icons.Default.CalendarMonth, "eventos"),
        Categoria("Gastronomía", R.drawable.gastronomia, Yellow_card, Icons.Default.RestaurantMenu, "gastronomia"),
        Categoria("Transporte", R.drawable.transporte, Green_card, Icons.Default.Commute, "transporte")
    )

    val searchText by viewModel.searchText.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(GradientStart, GradientEnd)
                        )
                    )
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("TravelMarket", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text("Juegos Panamericanos 2025", color = Color.White, style = MaterialTheme.typography.labelSmall)
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = searchText,
                    onValueChange = viewModel::onSearchTextChanged,
                    placeholder = { Text("Lugares, Eventos, Gastronomia, Transporte") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SelectedItemColor,
                        selectedTextColor = SelectedItemColor,
                        unselectedIconColor = UnselectedItemColor,
                        unselectedTextColor = UnselectedItemColor,
                        indicatorColor = Color.White
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("favoritos") },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") },
                    label = { Text("Favoritos") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SelectedItemColor,
                        selectedTextColor = SelectedItemColor,
                        unselectedIconColor = UnselectedItemColor,
                        unselectedTextColor = UnselectedItemColor,
                        indicatorColor = Color.White
                    )
                )
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (searchText.isBlank()) {
                Text(
                    text = "Explora",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(categorias) { categoria ->
                        Card(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clickable { navController.navigate(categoria.route) },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = categoria.imageRes),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(categoria.color.copy(alpha = 0.6f))
                                )
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = categoria.icon,
                                        contentDescription = categoria.nombre,
                                        tint = Color.White,
                                        modifier = Modifier.size(40.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = categoria.nombre,
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                    items(searchResults) { destino ->
                        SearchResultItem(destino = destino, navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchResultItem(destino: Destino, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { navController.navigate("detalle/${destino.id}") },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = destino.imageRes),
                contentDescription = destino.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = destino.nombre, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = destino.descripcion, color = Color.Gray, fontSize = 14.sp, maxLines = 1)
            }
        }
    }
}
