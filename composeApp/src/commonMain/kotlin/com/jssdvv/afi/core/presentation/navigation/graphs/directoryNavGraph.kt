package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.components.NavGraphRoutes
import com.jssdvv.afi.directory.presentation.DirectoryScreen

sealed class DirectoryRoutes(val route: String) {
    data object Home : DirectoryRoutes("directoryHome")
}

fun NavGraphBuilder.directoryNavGraph(navController: NavController) {
    navigation(
        route = NavGraphRoutes.Directory.route,
        startDestination = DirectoryRoutes.Home.route
    ) {
        composable(DirectoryRoutes.Home.route) {
           DirectoryScreen()
        }
    }
}