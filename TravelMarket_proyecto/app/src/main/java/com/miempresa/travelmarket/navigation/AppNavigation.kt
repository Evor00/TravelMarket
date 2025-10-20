
package com.miempresa.travelmarket.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miempresa.travelmarket.ui.detalle.DetailScreen
import com.miempresa.travelmarket.ui.eventos.EventosScreen
import com.miempresa.travelmarket.ui.favoritos.FavoriteScreen
import com.miempresa.travelmarket.ui.gastronomia.GastronomiaScreen
import com.miempresa.travelmarket.ui.home.HomeScreen
import com.miempresa.travelmarket.ui.lugares.LugaresScreen
import com.miempresa.travelmarket.ui.transporte.TransporteScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("lugares") { LugaresScreen(navController) }
        composable("eventos") { EventosScreen(navController) }
        composable("gastronomia") { GastronomiaScreen(navController) }
        composable("transporte") { TransporteScreen(navController) }
        composable("favoritos") { FavoriteScreen(navController) }

        composable(
            route = "detalle/{destinoId}",
            arguments = listOf(navArgument("destinoId") { type = NavType.StringType })
        ) { backStackEntry ->
            val destinoId = backStackEntry.arguments?.getString("destinoId")
            if (destinoId != null) {
                DetailScreen(navController = navController, destinoId = destinoId)
            }
        }
    }
}
