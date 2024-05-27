package com.jssdvv.afi.core.presentation.navigation.components

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
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

sealed class NavGraphRoutes(val route: String) {
    data object Scanner : NavGraphRoutes("scannerGraph")
    data object Directory : NavGraphRoutes("directoryGraph")
    data object Formats : NavGraphRoutes("formatsGraph")
    data object Maps : NavGraphRoutes("mapsGraph")
}

sealed class NavigationItems @OptIn(ExperimentalResourceApi::class) constructor(
    val title: StringResource,
    val route: String,
    val activeIcon: DrawableResource,
    val inactiveIcon: DrawableResource
) {
    @OptIn(ExperimentalResourceApi::class)
    data object ScannerItem : NavigationItems(
        title = Res.string.scanner_tab_title,
        route = NavGraphRoutes.Scanner.route,
        activeIcon = Res.drawable.scanner_filled,
        inactiveIcon = Res.drawable.scanner_outlined
    )

    @OptIn(ExperimentalResourceApi::class)
    data object FormatsItem : NavigationItems(
        title = Res.string.formats_tab_title,
        route = NavGraphRoutes.Formats.route,
        activeIcon = Res.drawable.formats_filled,
        inactiveIcon = Res.drawable.formats_outlined
    )

    @OptIn(ExperimentalResourceApi::class)
    data object DirectoryItem : NavigationItems(
        title = Res.string.directory_tab_title,
        route = NavGraphRoutes.Directory.route,
        activeIcon = Res.drawable.directory_filled,
        inactiveIcon = Res.drawable.directory_outlined
    )

    @OptIn(ExperimentalResourceApi::class)
    data object MapsItem : NavigationItems(
        title = Res.string.maps_tab_title,
        route = NavGraphRoutes.Maps.route,
        activeIcon = Res.drawable.maps_filled,
        inactiveIcon = Res.drawable.maps_outlined
    )
}