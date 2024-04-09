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
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jssdvv.afi.composeapp.generated.resources.Res
import com.jssdvv.afi.composeapp.generated.resources.close_outlined
import com.jssdvv.afi.composeapp.generated.resources.done_outlined
import com.jssdvv.afi.composeapp.generated.resources.flashlight_outlined
import com.jssdvv.afi.composeapp.generated.resources.flip_camera_outlined
import com.jssdvv.afi.core.presentation.navigation.LocalNavigationBarShown
import com.jssdvv.afi.core.presentation.navigation.LocalPaddingValues
import com.jssdvv.afi.scanner.presentation.components.CameraPreview
import com.jssdvv.afi.scanner.presentation.states.CameraScreenModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class CameraScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { CameraScreenModel() }
        val navigator = LocalNavigator.currentOrThrow
        val showBar = remember { mutableStateOf(true) }
        LocalNavigationBarShown.current.value = showBar.value

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(LocalPaddingValues.current.value)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                CameraPreview()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.2f))
                        .padding(15.dp)
                        .align(Alignment.TopCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            screenModel.toggleTorch()
                        }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.flashlight_outlined),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = {
                            screenModel.toggleCamera()
                        }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.flip_camera_outlined),
                            contentDescription = null
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                TextField(
                    value = screenModel.text.collectAsState().value,
                    onValueChange = screenModel::onTextChange,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                screenModel.onTextChange(String())
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
                    modifier = Modifier
                        .padding(15.dp)
                )
                IconButton(
                    onClick = {
                        showBar.value = false
                        navigator.push(DetailsScreen(screenModel.text.value))
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
}