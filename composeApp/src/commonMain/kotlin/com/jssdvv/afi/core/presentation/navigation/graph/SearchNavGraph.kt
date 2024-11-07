package com.jssdvv.afi.core.presentation.navigation.graph

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.AppNavRoutes

fun NavGraphBuilder.searchNavGraph() {
    navigation<AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph>(
        startDestination = AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.ScannerDestination
    ) {
        composable<AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.ScannerDestination> {
            Text("Scanner Destination")
        }
        composable<AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.ScannerDestination.DetailSubDestination> {
            Text("SplashDestination")
        }
        composable<AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.ScannerDestination.HistorySubDestination> {
            Text("SplashDestination")
        }
        composable<AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.DirectoryDestination> {
            Text("LoginDestination")
        }
    }
}