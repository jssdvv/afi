package com.jssdvv.afi.scanner.data.repositories

import android.content.Context
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.jssdvv.afi.scanner.data.model.MLKitAnalyzer
import com.jssdvv.afi.scanner.domain.repositories.CameraRepository

class CameraRepositoryImpl : CameraRepository {
    override fun getLifeCycleCameraController(
        lifecycleOwner: LifecycleOwner,
        analyzer: ImageAnalysis.Analyzer,
        context: Context
    ): LifecycleCameraController {
        return LifecycleCameraController(context).apply {
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            imageAnalysisTargetSize = CameraController.OutputSize(1)
            imageCaptureFlashMode = ImageCapture.FLASH_MODE_OFF
            imageCaptureMode = ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY
            imageCaptureTargetSize = CameraController.OutputSize(1)
            isPinchToZoomEnabled = false
            previewTargetSize = CameraController.OutputSize(1)
            isTapToFocusEnabled = true
            //enableTorch(false)
            setImageAnalysisAnalyzer(
                ContextCompat.getMainExecutor(context),
                analyzer
            )
            bindToLifecycle(lifecycleOwner)
        }
    }
}