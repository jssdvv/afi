package com.jssdvv.afi.core.presentation.navigation.graph

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jssdvv.afi.core.presentation.navigation.AppNavRoutes

fun NavGraphBuilder.authNavGraph() {
    navigation<AppNavRoutes.AuthNavGraph>(
        startDestination = AppNavRoutes.AuthNavGraph.LoginDestination
    ) {
        composable<AppNavRoutes.AuthNavGraph.SplashDestination> {
            Text("SplashDestination")
        }
        composable<AppNavRoutes.AuthNavGraph.LoginDestination> {
            Text("LoginDestination")
        }
        composable<AppNavRoutes.AuthNavGraph.RecoveryDestination> {
            Text("RecoveryDestination")
        }
    }

}