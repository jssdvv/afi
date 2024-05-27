package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.components.NavGraphRoutes

sealed class MapsRoutes(val route: String) {
    data object Home : DirectoryRoutes("mapsHome")
}

fun NavGraphBuilder.mapsNavGraph(navController: NavController) {
    navigation(
        route = NavGraphRoutes.Maps.route,
        startDestination = MapsRoutes.Home.route
    ) {
        composable(MapsRoutes.Home.route) {
            Text("Hola4")
        }
    }
}