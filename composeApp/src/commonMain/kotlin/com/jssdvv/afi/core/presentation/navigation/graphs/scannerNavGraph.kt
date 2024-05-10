package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.components.NavGraphRoutes

sealed class ScannerRoutes(val route: String) {
    data object Home : DirectoryRoutes("scannerHome")
}

fun NavGraphBuilder.scannerNavGraph(navController: NavController) {
    navigation(
        route = NavGraphRoutes.Scanner.route,
        startDestination = ScannerRoutes.Home.route
    ) {
        composable(ScannerRoutes.Home.route) {
            Text("Hola1")
        }
    }
}