package com.jssdvv.afi.presentation.navigation

import cafe.adriel.voyager.navigator.tab.Tab
import com.jssdvv.afi.MR
import com.jssdvv.afi.presentation.features.directory.DirectoryTab
import com.jssdvv.afi.presentation.features.formats.FormatsTab
import com.jssdvv.afi.presentation.features.maps.MapsTab
import com.jssdvv.afi.presentation.features.scanner.ScannerTab
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource

sealed class NavigationTabs(
    val title: StringResource,
    val inactiveIcon: ImageResource,
    val activeIcon: ImageResource,
    val tab: Tab
) {
    data object ScannerTab : NavigationTabs(
        title = MR.strings.scanner_tab_title,
        inactiveIcon = MR.images.scanner_outlined,
        activeIcon = MR.images.scanner_filled,
        tab = ScannerTab()
    )

    data object FormatsTab : NavigationTabs(
        title = MR.strings.formats_tab_title,
        inactiveIcon = MR.images.formats_outlined,
        activeIcon = MR.images.formats_filled,
        tab = FormatsTab()
    )

    data object DirectoryTab : NavigationTabs(
        title = MR.strings.directory_tab_title,
        inactiveIcon = MR.images.directory_outlined,
        activeIcon = MR.images.directory_filled,
        tab = DirectoryTab()
    )

    data object MapsTab : NavigationTabs(
        title = MR.strings.maps_tab_title,
        inactiveIcon = MR.images.maps_outlined,
        activeIcon = MR.images.maps_filled,
        tab = MapsTab()
    )
}