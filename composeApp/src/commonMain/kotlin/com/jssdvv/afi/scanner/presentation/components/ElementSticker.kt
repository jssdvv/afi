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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.jssdvv.afi.composeapp.generated.resources.Casio_fx_9860GII_Regular_Normal
import com.jssdvv.afi.composeapp.generated.resources.Res
import com.jssdvv.afi.composeapp.generated.resources.uis_vertical_logo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ElementSticker(
    text: String,
    padding: Dp,
    backgroundColor: Color = Color.White
) {
    val safeDistance = 4f
    val stickerRadius = 12
    val stickerWidth = 108f
    val stickerHeight = 41f
    val stickerAspectRatio = stickerWidth / stickerHeight
    val contentWidth = 100f
    val contentHeight = 33f

    Box(
        modifier = Modifier
            .padding(padding)
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .background(Color.Cyan)
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .weight(0.5f)
                        .wrapContentHeight(Alignment.CenterVertically),
                    fontFamily = FontFamily(Font(Res.font.Casio_fx_9860GII_Regular_Normal)),
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}