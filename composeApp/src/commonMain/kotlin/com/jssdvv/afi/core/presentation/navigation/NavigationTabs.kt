package com.jssdvv.afi.core.presentation.navigation

import cafe.adriel.voyager.navigator.tab.Tab
import com.jssdvv.afi.MR
import com.jssdvv.afi.composeapp.generated.resources.Res
import com.jssdvv.afi.composeapp.generated.resources.directory_filled
import com.jssdvv.afi.composeapp.generated.resources.directory_outlined
import com.jssdvv.afi.composeapp.generated.resources.directory_tab_title
import com.jssdvv.afi.composeapp.generated.resources.formats_filled
import com.jssdvv.afi.composeapp.generated.resources.formats_outlined
import com.jssdvv.afi.composeapp.generated.resources.formats_tab_title
import com.jssdvv.afi.composeapp.generated.resources.maps_filled
import com.jssdvv.afi.composeapp.generated.resources.maps_outlined
import com.jssdvv.afi.composeapp.generated.resources.maps_tab_title
import com.jssdvv.afi.composeapp.generated.resources.scanner_filled
import com.jssdvv.afi.composeapp.generated.resources.scanner_outlined
import com.jssdvv.afi.composeapp.generated.resources.scanner_tab_title
import com.jssdvv.afi.directory.presentation.screens.DirectoryTab
import com.jssdvv.afi.formats.presentation.screens.FormatsTab
import com.jssdvv.afi.maps.presentation.screens.MapsTab
import com.jssdvv.afi.scanner.presentation.screens.ScannerTab
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

sealed class NavigationTabs @OptIn(ExperimentalResourceApi::class) constructor(
    val title: StringResource,
    val inactiveIcon: DrawableResource,
    val activeIcon: DrawableResource,
    val tab: Tab,
    val index: UShort
) {
    @OptIn(ExperimentalResourceApi::class)
    data object ScannerTab : NavigationTabs(
        title = Res.string.scanner_tab_title,
        inactiveIcon = Res.drawable.scanner_outlined,//MR.images.scanner_outlined,
        activeIcon = Res.drawable.scanner_filled,
        tab = ScannerTab(),
        index = 0u
    )

    @OptIn(ExperimentalResourceApi::class)
    data object FormatsTab : NavigationTabs(
        title = Res.string.formats_tab_title,
        inactiveIcon = Res.drawable.formats_outlined,
        activeIcon = Res.drawable.formats_filled,
        tab = FormatsTab(),
        index = 1u
    )

    @OptIn(ExperimentalResourceApi::class)
    data object DirectoryTab : NavigationTabs(
        title = Res.string.directory_tab_title,
        inactiveIcon = Res.drawable.directory_outlined,
        activeIcon = Res.drawable.directory_filled,
        tab = DirectoryTab(),
        index = 2u
    )

    @OptIn(ExperimentalResourceApi::class)
    data object MapsTab : NavigationTabs(
        title = Res.string.maps_tab_title,
        inactiveIcon = Res.drawable.maps_outlined,
        activeIcon = Res.drawable.maps_filled,
        tab = MapsTab(),
        index = 3u
    )
}