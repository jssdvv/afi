package com.jssdvv.afi.presentation.features.scanner

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

class ScannerTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(
                    index = 2u,
                    title = "",
                    icon = null
                )
            }
        }
    @Composable
    override fun Content() {
        Text("Pantalla escaner")
    }
}