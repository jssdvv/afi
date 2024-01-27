package com.jssdvv.afi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jssdvv.afi.MR
import dev.icerock.moko.resources.compose.asFont

private val darkColorScheme = darkColorScheme(
    primary = Green80,
    onPrimary = Green20,
    primaryContainer = Green30,
    onPrimaryContainer = Green90,
    inversePrimary = Green40,
    secondary = GreenGray80,
    onSecondary = GreenGray20,
    secondaryContainer = GreenGray30,
    onSecondaryContainer = GreenGray90,
    tertiary = Blue80,
    onTertiary = Blue20,
    tertiaryContainer = Blue30,
    onTertiaryContainer = Blue90,
    background = Gray10,
    onBackground = Gray90,
    surface = Gray10,
    onSurface = Gray90,
    surfaceVariant = DarkGreenGray30,
    onSurfaceVariant = DarkGreenGray80,
    surfaceTint = Green80,
    inverseSurface = Gray90,
    inverseOnSurface = Gray20,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    outline = DarkGreenGray60,
    outlineVariant = DarkGreenGray30,
    scrim = Gray0
)

private val lightColorScheme = lightColorScheme(
    primary = Green40,
    onPrimary = Green100,
    primaryContainer = Green90,
    onPrimaryContainer = Green10,
    inversePrimary = Green80,
    secondary = GreenGray40,
    onSecondary = GreenGray100,
    secondaryContainer = GreenGray90,
    onSecondaryContainer = GreenGray10,
    tertiary = Blue40,
    onTertiary = Blue100,
    tertiaryContainer = Blue90,
    onTertiaryContainer = Blue10,
    background = Gray90,
    onBackground = Gray10,
    surface = Gray90,
    onSurface = Gray10,
    surfaceVariant = DarkGreenGray90,
    onSurfaceVariant = DarkGreenGray30,
    surfaceTint = Green40,
    inverseSurface = Gray20,
    inverseOnSurface = Gray90,
    error = Red40,
    onError = Red100,
    errorContainer = Red90,
    onErrorContainer = Red10,
    outline = DarkGreenGray50,
    outlineVariant = DarkGreenGray80,
    scrim = Gray0
)

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (darkTheme) {
        true -> darkColorScheme
        else -> lightColorScheme
    }
    val fonts = listOf(
        MR.fonts.Hum521BT_Light.normal.asFont(
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        MR.fonts.Hum521BT_Light.italic.asFont(
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),
        MR.fonts.Hum521BT_Regular.normal.asFont(
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        MR.fonts.Hum521BT_Regular.italic.asFont(
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        MR.fonts.Hum521BT_Bold.normal.asFont(
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        MR.fonts.Hum521BT_Bold.italic.asFont(
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        )
    )
    val fontFamily = FontFamily(fonts.requireNoNulls())
    val typography = Typography(

        displayLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            letterSpacing = 0.sp, //Must Be Adjusted To -0.25 Defined By Material 3 Documentation
        ),
        displayMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 45.sp,
            lineHeight = 52.sp,
            letterSpacing = 0.sp
        ),
        displaySmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        titleSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        ),
        bodySmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        labelMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        ),
        labelSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    )
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes().roundedShapes,
        typography = typography,
        content = content
    )
}
