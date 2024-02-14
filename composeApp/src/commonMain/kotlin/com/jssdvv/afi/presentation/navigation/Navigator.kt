package com.jssdvv.afi.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator


val LocalContentPadding = compositionLocalOf { mutableStateOf(PaddingValues()) }
@Composable
fun Navigator() {
    val localPaddingValues = remember { mutableStateOf(PaddingValues()) }
    val navigationItems = listOf(
        NavigationTabs.ScannerTab,
        NavigationTabs.FormatsTab,
        NavigationTabs.DirectoryTab,
        NavigationTabs.MapsTab
    )
    CompositionLocalProvider(
        LocalContentPadding provides localPaddingValues
    ){
        TabNavigator(
            navigationItems.first().tab
        ) { tabNavigator ->
            Scaffold(
                modifier = Modifier,
                bottomBar = { NavigationBar(tabNavigator, navigationItems) },
                topBar = { TopBar() }
            ) { paddingValues ->
                localPaddingValues.value = paddingValues
                CurrentTab()
            }
        }
    }
}
