package com.jssdvv.afi.scanner.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jssdvv.afi.composeapp.generated.resources.Res
import com.jssdvv.afi.composeapp.generated.resources.close_outlined
import com.jssdvv.afi.composeapp.generated.resources.done_outlined
import com.jssdvv.afi.composeapp.generated.resources.flip_camera_outlined
import com.jssdvv.afi.composeapp.generated.resources.torch_filled
import com.jssdvv.afi.composeapp.generated.resources.torch_outlined
import com.jssdvv.afi.core.presentation.navigation.graphs.ScannerRoutes
import com.jssdvv.afi.core.presentation.theme.LocalTorchMode
import com.jssdvv.afi.scanner.presentation.components.CameraPreview
import com.jssdvv.afi.scanner.presentation.states.ScannerCameraViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ScannerCameraScreen(
    navController: NavController,
) {
    val viewModel = viewModel<ScannerCameraViewModel>()
    val showBar = remember { mutableStateOf(true) }
    //LocalNavigationBarShown.current.value = showBar.value

    val text = viewModel.text.collectAsState()
    val isTorchEnabled = viewModel.isTorchEnabled.collectAsState()
    val isCameraFlipped = viewModel.isCameraFlipped.collectAsState()
    LocalTorchMode.current.value = if (isCameraFlipped.value) isTorchEnabled.value else false

    Column(
        modifier = Modifier.fillMaxSize().padding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.75f)
                .clip(RoundedCornerShape(15.dp))
        ) {
            CameraPreview(
                navController = navController,
                isTorchEnabled = isTorchEnabled.value,
                isCameraFlipped = isCameraFlipped.value,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (isCameraFlipped.value && isTorchEnabled.value) {
                            Color.White
                        } else {
                            Color.Black.copy(alpha = 0.5f)
                        }
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp,
                    )
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { viewModel.toggleTorch() }) {
                    Icon(
                        painter = painterResource(
                            if (isTorchEnabled.value) Res.drawable.torch_filled else Res.drawable.torch_outlined
                        ),
                        contentDescription = null,
                        tint = if (isCameraFlipped.value && isTorchEnabled.value) Color.Black else Color.White
                    )
                }
                IconButton(onClick = { viewModel.toggleCamera() }) {
                    Icon(
                        painter = painterResource(Res.drawable.flip_camera_outlined),
                        contentDescription = null,
                        tint = if (isCameraFlipped.value && isTorchEnabled.value) Color.Black else Color.White
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(15.dp)
        ) {
            TextField(
                value = text.value,
                onValueChange = viewModel::onTextChange,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            viewModel.onTextChange(String())
                        }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.close_outlined),
                            contentDescription = null
                        )
                    }
                },
                singleLine = true,
                maxLines = 1,
                shape = CircleShape,
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Spacer(
                modifier = Modifier.padding(15.dp)
            )
            FloatingActionButton(
                onClick = {
                    showBar.value = false
                    navController.navigate(ScannerRoutes.Details.createRoute(text.value))
                }
            ) {
                Icon(
                    painter = painterResource(Res.drawable.done_outlined),
                    contentDescription = null
                )
            }
        }
    }
}
