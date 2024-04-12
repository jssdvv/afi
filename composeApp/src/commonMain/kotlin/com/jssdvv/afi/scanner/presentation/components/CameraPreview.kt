package com.jssdvv.afi.scanner.presentation.components

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.StateFlow

@Composable
expect fun CameraPreview(
    isTorchEnabled: Boolean,
    isCameraFlipped: Boolean,
    zoomRatio: Float
)