package com.jssdvv.afi.core.presentation.navigation.graph

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.AppNavRoutes

fun NavGraphBuilder.formatNavGraph() {
    navigation<AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph>(
        startDestination = AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.RequestDestination
    ) {
        composable<AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.RequestDestination> {
            Text("Request Destination")
        }
        composable<AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.ReportingDestination> {
            Text("Reporting Destination")
        }
        composable<AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.ConsultationDestination> {
            Text("Consultation Destination")
        }
    }
}