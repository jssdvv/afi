package com.jssdvv.afi.presentation.features.scanner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.MR
import com.jssdvv.afi.presentation.navigation.LocalContentPadding
import dev.icerock.moko.resources.compose.stringResource

class ScannerTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(MR.strings.scanner_tab_title)
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
        val paddingValues = LocalContentPadding.current
        Box(
            modifier = Modifier
                .padding(paddingValues.value)
        ) {
            Text("Pantalla escaner")
        }
    }
}