package com.miempresa.travelmarket.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miempresa.travelmarket.ui.home.HomeScreen
import com.miempresa.travelmarket.ui.detalle.DetalleScreen
import com.miempresa.travelmarket.ui.favoritos.FavoriteScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("detalle/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetalleScreen(id = id)
        }
        composable("favoritos") { FavoriteScreen(navController) }
    }
}
