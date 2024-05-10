package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.NavGraphRoutes

sealed class DirectoryRoutes(val route: String) {
    data object Home : DirectoryRoutes("directoryHome")
}

fun NavGraphBuilder.directoryNavGraph(navController: NavController) {
    navigation(
        route = NavGraphRoutes.Directory.route,
        startDestination = DirectoryRoutes.Home.route
    ) { }
}