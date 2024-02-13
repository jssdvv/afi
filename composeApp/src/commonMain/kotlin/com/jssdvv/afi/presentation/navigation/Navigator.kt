package com.jssdvv.afi.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.jssdvv.afi.presentation.features.scanner.ScannerTab

@Composable
fun Navigator() {
    TabNavigator(
        tab = ScannerTab()
    ) { tabNavigator ->
        Scaffold(
            modifier = Modifier,
            bottomBar = { NavigationBottomBar(tabNavigator) }
        ) { paddingValues ->
            CurrentTab()
        }
    }
}
