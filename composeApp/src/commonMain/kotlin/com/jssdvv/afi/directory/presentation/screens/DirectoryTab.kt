package com.jssdvv.afi.directory.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.jssdvv.afi.MR
import com.jssdvv.afi.directory.presentation.states.DirectoryTabModel
import com.jssdvv.afi.presentation.navigation.LocalContentPadding
import dev.icerock.moko.resources.compose.stringResource
import io.ktor.client.plugins.RedirectResponseException
import kotlinx.coroutines.launch

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
        val screenModel = rememberScreenModel { DirectoryTabModel() }
        val text = screenModel.httpResponse.collectAsState()
        val lazyColumnState = rememberLazyListState()

        val scope = rememberCoroutineScope()
        LaunchedEffect(true) {
            scope.launch {
                try {
                    screenModel.getHtmlAsText()
                } catch (e: RedirectResponseException) {
                    println(e.response.status.description)
                }
            }
        }
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues.value)
                .fillMaxSize(),
            state = lazyColumnState,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Text(
                    text = text.value,
                )
            }
        }
    }
}