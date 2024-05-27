package com.jssdvv.afi.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jssdvv.afi.core.presentation.navigation.components.NavigationItems
import com.jssdvv.afi.core.presentation.navigation.graphs.directoryNavGraph
import com.jssdvv.afi.core.presentation.navigation.graphs.formatsNavGraph
import com.jssdvv.afi.core.presentation.navigation.graphs.mapsNavGraph
import com.jssdvv.afi.core.presentation.navigation.graphs.scannerNavGraph

@Composable
fun NavigationHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItems.ScannerItem.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        scannerNavGraph(navController)
        formatsNavGraph(navController)
        directoryNavGraph(navController)
        mapsNavGraph(navController)
    }
}