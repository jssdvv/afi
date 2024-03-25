package com.jssdvv.afi.scanner.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.jssdvv.afi.composeapp.generated.resources.Res
import com.jssdvv.afi.composeapp.generated.resources.uis_vertical_logo
import com.jssdvv.afi.core.presentation.theme.typography.CasioFX9860GIIFontFamily
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ElementSticker(
    text: String,
    padding: Dp,
    height: Dp,
    backgroundColor: Color = Color.White
) {
    val safeDistance = 4f
    val stickerRadius = 12
    val stickerWidth = 108f
    val stickerHeight = 41f
    val stickerAspectRatio = stickerWidth / stickerHeight
    val logoSquareSide = 16f
    val contentWidth = 100f
    val contentHeight = 33f

    var fontSize by remember { mutableStateOf(height.value * (logoSquareSide / 2) / stickerHeight) }

    Box(
        modifier = Modifier
            .padding(padding)
            .height(height)
            .clip(RoundedCornerShape(stickerRadius))
            .background(backgroundColor)
            .aspectRatio(ratio = stickerAspectRatio)
            .wrapContentSize(align = Alignment.Center)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(contentHeight / stickerHeight)
                .fillMaxWidth(contentWidth / stickerWidth)
        ) {
            Image(
                painter = painterResource(Res.drawable.uis_vertical_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight()
            )
            Spacer(
                modifier = Modifier.fillMaxWidth(safeDistance / contentWidth)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(logoSquareSide / contentHeight)
                        .background(Color.Cyan)
                )
                Spacer(
                    modifier = Modifier.weight(1f / contentHeight)
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .weight(logoSquareSide / contentHeight)
                        .wrapContentHeight(Alignment.CenterVertically),
                    fontFamily = CasioFX9860GIIFontFamily(),
                    fontSize = fontSize.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    onTextLayout = { textLayoutResult ->
                        if (textLayoutResult.didOverflowHeight) {
                            fontSize =
                                textLayoutResult.size.height * (logoSquareSide / 2) / stickerHeight
                        }
                    }
                )
            }
        }
    }
}