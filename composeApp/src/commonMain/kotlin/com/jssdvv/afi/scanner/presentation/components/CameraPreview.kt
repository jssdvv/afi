package com.jssdvv.afi.scanner.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.Navigator
import kotlinx.coroutines.flow.StateFlow

@Composable
expect fun CameraPreview(
    navController: NavController,
    isTorchEnabled: Boolean,
    isCameraFlipped: Boolean
)