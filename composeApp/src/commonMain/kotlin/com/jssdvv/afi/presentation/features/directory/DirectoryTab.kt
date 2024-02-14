package com.jssdvv.afi.presentation.features.directory

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.MR
import com.jssdvv.afi.presentation.navigation.LocalContentPadding
import dev.icerock.moko.resources.compose.stringResource

class DirectoryTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(MR.strings.directory_tab_title)
            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = null
                )
            }
        }
    @Composable
    override fun Content() {
        val paddingValues = LocalContentPadding.current
        Text("Pantalla directorio")
    }
}