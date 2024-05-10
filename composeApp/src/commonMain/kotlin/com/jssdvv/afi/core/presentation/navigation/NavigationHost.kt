package com.jssdvv.afi.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jssdvv.afi.core.presentation.navigation.graphs.directoryNavGraph
import com.jssdvv.afi.core.presentation.navigation.graphs.formatsNavGraph
import com.jssdvv.afi.core.presentation.navigation.graphs.mapsNavGraph
import com.jssdvv.afi.core.presentation.navigation.graphs.scannerNavGraph

sealed class NavGraphRoutes(val route: String) {
    data object Scanner : NavGraphRoutes("scannerGraph")
    data object Directory : NavGraphRoutes("directoryGraph")
    data object Formats : NavGraphRoutes("formatsGraph")
    data object Maps : NavGraphRoutes("mapsGraph")
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavGraphRoutes.Scanner.route,
    ) {
        scannerNavGraph(navController)
        directoryNavGraph(navController)
        formatsNavGraph(navController)
        mapsNavGraph(navController)
    }
}