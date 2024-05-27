package com.jssdvv.afi.core.presentation.navigation.graphs

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.components.NavGraphRoutes

sealed class FormatsRoutes(val route: String) {
    data object Home : DirectoryRoutes("formatsHome")
}

fun NavGraphBuilder.formatsNavGraph(navController: NavController) {
    navigation(
        route = NavGraphRoutes.Formats.route,
        startDestination = FormatsRoutes.Home.route
    ) {
        composable(FormatsRoutes.Home.route) {
            Text("Hola2")
        }
    }
}