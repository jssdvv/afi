package com.jssdvv.afi.formats.presentation.screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.core.presentation.navigation.NavigationItems
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

class FormatsTab : Tab {
    @OptIn(ExperimentalResourceApi::class)
    override val options
        @Composable get() = TabOptions(
            index = NavigationItems.FormatsItem.index,
            title = stringResource(NavigationItems.FormatsItem.title)
        )

    @Composable
    override fun Content() {

    }
}