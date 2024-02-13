package com.jssdvv.afi.presentation.features.directory

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

class DirectoryTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Directory"
            val icon = null

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = null
                )
            }
        }
    @Composable
    override fun Content() {
        Text("Pantalla directorio")
    }
}