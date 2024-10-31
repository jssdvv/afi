package com.jssdvv.afi.scanner.presentation.components

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.camera.core.CameraSelector
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.jssdvv.afi.core.presentation.navigation.graphs.ScannerRoutes
import com.jssdvv.afi.scanner.data.model.MLKitAnalyzer
import com.jssdvv.afi.scanner.data.repositories.CameraRepositoryImpl

@Composable
actual fun CameraPreview(
    navController: NavController,
    isTorchEnabled: Boolean,
    isCameraFlipped: Boolean
) {
    val localContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleCameraController = remember {
        CameraRepositoryImpl().getLifeCycleCameraController(
            lifecycleOwner,
            MLKitAnalyzer { barcode ->
                navController.navigate(ScannerRoutes.Details.createRoute(barcode.rawValue.toString()))
            },
            context = localContext
        )
    }.apply {
        cameraSelector =
            if (isCameraFlipped) CameraSelector.DEFAULT_FRONT_CAMERA else CameraSelector.DEFAULT_BACK_CAMERA
        //enableTorch(isTorchEnabled)
    }
    AndroidView(
        modifier = Modifier.fillMaxSize(),
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
        }
    )
}