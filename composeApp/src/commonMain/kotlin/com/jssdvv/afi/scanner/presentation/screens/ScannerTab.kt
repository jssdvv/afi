package com.jssdvv.afi.scanner.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.core.presentation.navigation.LocalContentPadding
import com.jssdvv.afi.core.presentation.navigation.NavigationTabs
import com.jssdvv.afi.scanner.presentation.components.CameraPreview
import com.jssdvv.afi.scanner.presentation.states.ScannerTabModel

class ScannerTab : Tab {
    override val options
        @Composable get() = TabOptions(
            index = NavigationTabs.ScannerTab.index,
            title = String()
        )

    @Composable
    override fun Content() {
        val paddingValues = LocalContentPadding.current
        val screenModel = rememberScreenModel { ScannerTabModel() }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues.value)
        ) {
            CameraPreview()
        }
    }
}

