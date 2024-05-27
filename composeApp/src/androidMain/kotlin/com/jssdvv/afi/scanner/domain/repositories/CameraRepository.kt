package com.jssdvv.afi.scanner.domain.repositories

import android.content.Context
import androidx.camera.core.CameraProvider
import androidx.camera.core.ImageAnalysis
import androidx.camera.view.LifecycleCameraController
import androidx.lifecycle.LifecycleOwner

interface CameraRepository {
    fun getLifeCycleCameraController(
        lifecycleOwner: LifecycleOwner,
        analyzer: ImageAnalysis.Analyzer,
        context: Context
    ) : LifecycleCameraController
}