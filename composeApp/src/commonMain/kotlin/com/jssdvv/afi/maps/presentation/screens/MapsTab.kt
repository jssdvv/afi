package com.jssdvv.afi.maps.presentation.screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.core.presentation.navigation.NavigationItems
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

class MapsTab : Tab {
    @OptIn(ExperimentalResourceApi::class)
    override val options
        @Composable get() = TabOptions(
            index = NavigationItems.MapsItem.index,
            title = stringResource(NavigationItems.MapsItem.title)
        )

    @Composable
    override fun Content() {

    }
}