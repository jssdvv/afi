package com.jssdvv.afi.presentation.features.formats

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.MR
import dev.icerock.moko.resources.compose.stringResource

class FormatsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(MR.strings.formats_tab_title)
            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = null
                )
            }
        }
    @Composable
    override fun Content() {
        Text("Pantalla formatos")
    }
}