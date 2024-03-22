package com.jssdvv.afi.core.presentation.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jssdvv.afi.composeapp.generated.resources.Hum521BT_Bold_Italic
import com.jssdvv.afi.composeapp.generated.resources.Hum521BT_Bold_Normal
import com.jssdvv.afi.composeapp.generated.resources.Hum521BT_Light_Italic
import com.jssdvv.afi.composeapp.generated.resources.Hum521BT_Light_Normal
import com.jssdvv.afi.composeapp.generated.resources.Hum521BT_Regular_Italic
import com.jssdvv.afi.composeapp.generated.resources.Hum521BT_Regular_Normal
import com.jssdvv.afi.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Hum521BTFontFamily() = FontFamily(
    Font(
        resource = Res.font.Hum521BT_Light_Normal,
        weight = FontWeight.Light,
        style = FontStyle.Normal,
    ),
    Font(
        resource = Res.font.Hum521BT_Light_Italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic,
    ),
    Font(
        resource = Res.font.Hum521BT_Regular_Normal,
        weight = FontWeight.Normal,
        style = FontStyle.Normal,
    ),
    Font(
        resource = Res.font.Hum521BT_Regular_Italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic,
    ),
    Font(
        resource = Res.font.Hum521BT_Bold_Normal,
        weight = FontWeight.Bold,
        style = FontStyle.Normal,
    ),
    Font(
        resource = Res.font.Hum521BT_Bold_Italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic,
    )
)

@Composable
fun Hum521BTTypography() = Typography(
    displayLarge = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp, // Must to be adjusted to -0.25 by Material 3 documentation
    ),
    displayMedium = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Hum521BTFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
