package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.components.NavGraphRoutes
import com.jssdvv.afi.scanner.presentation.screens.ScannerCameraScreen
import com.jssdvv.afi.scanner.presentation.screens.ScannerDetailsScreen

sealed class ScannerRoutes(val route: String) {
    data object Camera : ScannerRoutes("scannerCamera")
    data object Details : ScannerRoutes("scannerDetails?barcode={barcode}") {
        fun createRoute(barcode: String) = "scannerDetails?barcode=$barcode"
    }
}

fun NavGraphBuilder.scannerNavGraph(
    navController: NavController
) {
    navigation(
        route = NavGraphRoutes.Scanner.route,
        startDestination = ScannerRoutes.Camera.route
    ) {
        composable(ScannerRoutes.Camera.route) {
            ScannerCameraScreen(
                navController = navController
            )
        }
        composable(
            route = ScannerRoutes.Details.route,
            arguments = listOf(
                navArgument(
                    name = "barcode",
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            it.arguments?.getString("barcode")?.let { barcode ->
                ScannerDetailsScreen(
                    navController = navController,
                    barcode = barcode
                )
            }
        }
    }
}