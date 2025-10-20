package com.miempresa.travelmarket.ui.eventos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.miempresa.travelmarket.data.Repository
import com.miempresa.travelmarket.models.Evento
import com.miempresa.travelmarket.ui.theme.GradientEnd
import com.miempresa.travelmarket.ui.theme.GradientStart
import com.miempresa.travelmarket.ui.theme.SelectedItemColor
import com.miempresa.travelmarket.ui.theme.UnselectedItemColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventosScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    val eventos by remember { mutableStateOf(Repository.eventos) }

    val filteredEventos = if (searchQuery.isEmpty()) {
        eventos
    } else {
        eventos.filter {
            it.nombre.contains(searchQuery, ignoreCase = true) ||
                    it.descripcion.contains(searchQuery, ignoreCase = true)
        }
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(colors = listOf(GradientStart, GradientEnd))
                    )
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                    Text(
                        "Eventos",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /* TODO: Calendar action */ }) {
                        Icon(Icons.Default.CalendarMonth, contentDescription = "Calendario", tint = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Buscar eventos o zona...") },
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
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("home") { popUpTo("home") { inclusive = true } } },
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF0F0F0)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = if (searchQuery.isEmpty()) "Eventos Destacados" else "Resultados de la búsqueda",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(filteredEventos, key = { it.id }) { evento ->
                EventoCard(evento = evento, navController = navController)
            }
        }
    }
}

@Composable
fun EventoCard(evento: Evento, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("detalle/${evento.id}") },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = evento.imageRes),
                    contentDescription = evento.nombre,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Surface(
                    modifier = Modifier.padding(12.dp),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Red
                ) {
                    Text(
                        text = evento.fecha,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(evento.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(evento.descripcion, fontSize = 14.sp, color = Color.Gray, maxLines = 1)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
