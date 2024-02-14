package com.jssdvv.afi.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.Tab
import com.jssdvv.afi.MR
import com.jssdvv.afi.presentation.features.directory.DirectoryTab
import com.jssdvv.afi.presentation.features.formats.FormatsTab
import com.jssdvv.afi.presentation.features.scanner.ScannerTab
import dev.icerock.moko.resources.StringResource

sealed class NavigationTabs(
    val title: StringResource,
    val inactiveIcon: ImageVector,
    val activeIcon: ImageVector,
    val tab: Tab
) {
    data object ScannerTab : NavigationTabs(
        title = MR.strings.scanner_tab_title,
        inactiveIcon = Icons.Outlined.Home,
        activeIcon = Icons.Filled.Home,
        tab = ScannerTab()
    )

    data object FormatsTab : NavigationTabs(
        title = MR.strings.formats_tab_title,
        inactiveIcon = Icons.Outlined.Email,
        activeIcon = Icons.Filled.Email,
        tab = FormatsTab()
    )

    data object DirectoryTab : NavigationTabs(
        title = MR.strings.directory_tab_title,
        inactiveIcon = Icons.Outlined.Info,
        activeIcon = Icons.Filled.Info,
        tab = DirectoryTab()
    )
}