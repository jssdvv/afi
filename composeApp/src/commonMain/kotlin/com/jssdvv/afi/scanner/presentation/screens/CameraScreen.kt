package com.jssdvv.afi.scanner.presentation.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jssdvv.afi.core.presentation.navigation.LocalNavigationBarShown
import com.jssdvv.afi.core.presentation.navigation.LocalPaddingValues
import com.jssdvv.afi.scanner.presentation.components.CameraPreview
import com.jssdvv.afi.scanner.presentation.states.ScannerScreenModel

class CameraScreen : Screen {
    @Composable
    override fun Content() {
        val showBar = remember { mutableStateOf(true) }
        LocalNavigationBarShown.current.value = showBar.value
        val paddingValues = LocalPaddingValues.current.value
        val screenModel = rememberScreenModel { ScannerScreenModel() }
        val text = screenModel.value.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CameraPreview()
            Row(
                modifier = Modifier
                    .align(
                        alignment = Alignment.TopEnd
                    )
            ) {
                TextField(
                    value = text.value,
                    onValueChange = screenModel::onValueChange
                )
                Button(
                    onClick = {
                        showBar.value = false
                        navigator.push(DetailsScreen("123456"))
                    }
                ) {

                }
            }
        }
    }
}