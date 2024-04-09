package com.jssdvv.afi.directory.presentation.screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.core.presentation.navigation.NavigationItems
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

class DirectoryTab : Tab {
    @OptIn(ExperimentalResourceApi::class)
    override val options
        @Composable get() = TabOptions(
            index = NavigationItems.DirectoryItem.index,
            title = stringResource(NavigationItems.DirectoryItem.title)
        )

    @Composable
    override fun Content() {

    }
}