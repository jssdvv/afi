package com.jssdvv.afi.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.jssdvv.afi.core.presentation.navigation.components.NavigationBar
import com.jssdvv.afi.core.presentation.navigation.components.TopBar

val LocalPaddingValues = compositionLocalOf { mutableStateOf(PaddingValues()) }
val LocalNavigationBarShown = compositionLocalOf { mutableStateOf(true) }

@Composable
fun TabNavigation() {
    val localPaddingValues = remember { mutableStateOf(PaddingValues()) }
    val localNavigationBarShown = remember { mutableStateOf(true) }
    val navigationTabs = listOf(
        NavigationItems.ScannerItem,
        NavigationItems.FormatsItem,
        NavigationItems.DirectoryItem,
        NavigationItems.MapsItem
    )
    CompositionLocalProvider(
        LocalPaddingValues provides localPaddingValues,
        LocalNavigationBarShown provides localNavigationBarShown
    ) {
        TabNavigator(
            tab = navigationTabs.first().tab,
            disposeNestedNavigators = true
        ) { tabNavigator ->
            Scaffold(
                modifier = Modifier,
                bottomBar = {
                    if (LocalNavigationBarShown.current.value) {
                        NavigationBar(tabNavigator, navigationTabs)
                    }
                },
                topBar = {
                    when (tabNavigator.current.options.index.toUInt()) {
                        0u -> TopBar()
                        1u -> TopBar()
                        2u -> TopBar()
                        3u -> TopBar()
                    }
                }
            ) { paddingValues ->
                LocalPaddingValues.current.value = paddingValues
                CurrentTab()
            }
        }
    }
}
