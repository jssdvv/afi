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
import androidx.navigation.NavController
import com.jssdvv.afi.scanner.presentation.components.ElementSticker

@Composable
fun ScannerDetailsScreen(
    navController: NavController,
    barcode: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElementSticker(
            text = barcode,
            padding = 10.dp,
            height = 120.dp,
            backgroundColor = Color.White
        )
    }
}