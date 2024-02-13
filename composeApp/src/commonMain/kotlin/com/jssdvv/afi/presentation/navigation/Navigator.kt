package com.jssdvv.afi.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator

@Composable
fun Navigator() {
    val navigationItems = listOf(
        NavigationItem.ScannerItem,
        NavigationItem.FormatsItem,
        NavigationItem.DirectoryItem
    )
    TabNavigator(
        navigationItems.first().tab
    ) { tabNavigator ->
        Scaffold(
            modifier = Modifier,
            bottomBar = { NavigationBar(tabNavigator, navigationItems) },
            topBar = { TopBar() }
        ) { paddingValues ->
            CurrentTab()
        }
    }
}
