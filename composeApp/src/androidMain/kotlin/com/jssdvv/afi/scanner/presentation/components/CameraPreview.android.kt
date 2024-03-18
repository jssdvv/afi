package com.jssdvv.afi.scanner.presentation.components

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun CameraPreview() {
    val localContext = LocalContext.current
    val lifecycleCameraController = LifecycleCameraController(localContext)
    val lifecycleOwner = LocalLifecycleOwner.current

    AndroidView(
        factory = { context ->
            PreviewView(context).apply {
                controller = lifecycleCameraController
                lifecycleCameraController.bindToLifecycle(lifecycleOwner)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                implementationMode = PreviewView.ImplementationMode.PERFORMANCE
                scaleType = PreviewView.ScaleType.FILL_START
                visibility = View.VISIBLE
            }
        },
        modifier = Modifier,
        update = { previewView ->

        }
    )

}