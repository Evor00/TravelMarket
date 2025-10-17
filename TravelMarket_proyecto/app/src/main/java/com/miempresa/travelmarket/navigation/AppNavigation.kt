package com.miempresa.travelmarket.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miempresa.travelmarket.ui.detalle.DetailEventoScreen
import com.miempresa.travelmarket.ui.detalle.DetailGastroScreen
import com.miempresa.travelmarket.ui.detalle.DetailLugarScreen
import com.miempresa.travelmarket.ui.detalle.DetailTransporteScreen
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
            route = "detalleLugar/{lugarIndex}",
            arguments = listOf(navArgument("lugarIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val lugarIndex = backStackEntry.arguments?.getInt("lugarIndex") ?: 0
            DetailLugarScreen(navController, lugarIndex)
        }

        composable(
            route = "detalleEvento/{eventoIndex}",
            arguments = listOf(navArgument("eventoIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val eventoIndex = backStackEntry.arguments?.getInt("eventoIndex") ?: 0
            DetailEventoScreen(navController, eventoIndex)
        }

        composable(
            route = "detalleGastro/{gastroIndex}",
            arguments = listOf(navArgument("gastroIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val gastroIndex = backStackEntry.arguments?.getInt("gastroIndex") ?: 0
            DetailGastroScreen(navController, gastroIndex)
        }

        composable(
            route = "detalleTransporte/{transporteIndex}",
            arguments = listOf(navArgument("transporteIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val transporteIndex = backStackEntry.arguments?.getInt("transporteIndex") ?: 0
            DetailTransporteScreen(navController, transporteIndex)
        }
    }
}
