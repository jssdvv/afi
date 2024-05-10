package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.NavGraphRoutes

sealed class ScannerRoutes(val route: String) {
    data object Home : DirectoryRoutes("scannerHome")
}

fun NavGraphBuilder.scannerNavGraph(navController: NavController) {
    navigation(
        route = NavGraphRoutes.Scanner.route,
        startDestination = ScannerRoutes.Home.route
    ) { }
}