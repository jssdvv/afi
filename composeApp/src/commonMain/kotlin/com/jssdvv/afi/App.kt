package com.jssdvv.afi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jssdvv.afi.core.presentation.navigation.Navigator
import com.jssdvv.afi.core.presentation.theme.Theme

@Composable
fun App() {
    Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigator()
        }
    }
}

