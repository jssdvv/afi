package com.jssdvv.afi.scanner.presentation.screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.jssdvv.afi.core.presentation.navigation.NavigationTabs
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

object ScannerTab : Tab {
    @OptIn(ExperimentalResourceApi::class)
    override val options
        @Composable get() = TabOptions(
            index = NavigationTabs.Scanner.index,
            title = stringResource(NavigationTabs.Scanner.title)
        )

    @Composable
    override fun Content() {
        Navigator(CameraScreen()) { navigator ->
            LifecycleEffect(onStarted = { navigator.popUntilRoot() })
            SlideTransition(navigator = navigator)
        }
    }
}