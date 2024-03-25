package com.jssdvv.afi.scanner.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.jssdvv.afi.core.presentation.navigation.LocalPaddingValues
import com.jssdvv.afi.scanner.presentation.components.ElementSticker

data class DetailsScreen(
    val barcode: String
) : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .padding(LocalPaddingValues.current.value)
                .fillMaxSize()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElementSticker(
                text = "123456",
                padding = 10.dp,
                height = 120.dp,
                backgroundColor = Color.White
            )
        }
    }
}