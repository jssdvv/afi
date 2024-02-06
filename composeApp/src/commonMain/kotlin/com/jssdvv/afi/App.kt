package com.jssdvv.afi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.jssdvv.afi.presentation.navigation.features.scanner.ScannerScreen
import com.jssdvv.afi.presentation.theme.Theme

@Composable
fun App() {
    Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigator(ScannerScreen())
        }
    }
}

