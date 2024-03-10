package com.jssdvv.afi.scanner.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.MR
import com.jssdvv.afi.core.presentation.navigation.LocalContentPadding
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

        Column(
            modifier = Modifier
                .padding(paddingValues.value)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth(0.33f)
                .height(40.dp)
                .background(Color.Green))
            Text("Pantalla escaner")
        }
    }
}