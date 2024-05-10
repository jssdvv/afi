package com.jssdvv.afi.core.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jssdvv.afi.core.presentation.navigation.components.NavigationBar
import com.jssdvv.afi.core.presentation.navigation.components.TopBar

@Composable
fun NavigationScaffold(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier,
        topBar = { TopBar(navController) },
        bottomBar = { NavigationBar(navController) }
    ) { paddingValues ->
        NavigationHost(navController, paddingValues)
    }
}