package com.campground.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = CampGroundColor.White,
    onPrimary = CampGroundColor.Blue01,
    primaryContainer = CampGroundColor.Graphite,
    onPrimaryContainer = CampGroundColor.White,
    inversePrimary = CampGroundColor.Blue02,
    secondary = CampGroundColor.Blue04,
    onSecondary = CampGroundColor.Blue01,
    secondaryContainer = CampGroundColor.Blue04,
    onSecondaryContainer = CampGroundColor.LightWhite,
    surfaceContainerLow = CampGroundColor.LightWhite,
    tertiary = CampGroundColor.Yellow05,
    onTertiary = CampGroundColor.Yellow01,
    tertiaryContainer = CampGroundColor.Yellow04,
    onTertiaryContainer = CampGroundColor.White,
    error = CampGroundColor.Red02,
    onError = CampGroundColor.Red05,
    errorContainer = CampGroundColor.Red04,
    onErrorContainer = CampGroundColor.Red01,
    surface = CampGroundColor.Graphite,
    onSurface = CampGroundColor.White,
    onSurfaceVariant = CampGroundColor.White,
    surfaceVariant = CampGroundColor.White,
    surfaceDim = CampGroundColor.Black,
    surfaceContainerHigh = CampGroundColor.DuskGray,
    inverseSurface = CampGroundColor.Neon05,
    inverseOnSurface = CampGroundColor.Black,
    outline = CampGroundColor.DarkGray,
    outlineVariant = CampGroundColor.Cosmos,
    scrim = CampGroundColor.Black,
    surfaceContainerLowest = CampGroundColor.Graphite,
)

private val LightColorScheme = lightColorScheme(
    primary = CampGroundColor.Neon01,
    onPrimary = CampGroundColor.White,
    primaryContainer = CampGroundColor.White,
    onPrimaryContainer = CampGroundColor.Graphite,
    inversePrimary = CampGroundColor.Neon01,
    secondary = CampGroundColor.Blue04,
    onSecondary = CampGroundColor.White,
    secondaryContainer = CampGroundColor.Blue01,
    onSecondaryContainer = CampGroundColor.LightBlack,
    surfaceContainerLow = CampGroundColor.Blue01,
    tertiary = CampGroundColor.Yellow01,
    onTertiary = CampGroundColor.Black,
    tertiaryContainer = CampGroundColor.Yellow03A40,
    onTertiaryContainer = CampGroundColor.Yellow04,
    error = CampGroundColor.Red03,
    onError = CampGroundColor.White,
    errorContainer = CampGroundColor.Red01,
    onErrorContainer = CampGroundColor.Red06,
    surface = CampGroundColor.White,
    onSurface = CampGroundColor.Black,
    onSurfaceVariant = CampGroundColor.DarkGray,
    surfaceVariant = CampGroundColor.Graphite,
    surfaceDim = CampGroundColor.PaleGray,
    surfaceContainerHigh = CampGroundColor.LightGray,
    inverseSurface = CampGroundColor.Yellow05,
    inverseOnSurface = CampGroundColor.White,
    outline = CampGroundColor.Gainsboro,
    outlineVariant = CampGroundColor.DarkGray,
    scrim = CampGroundColor.Black,
    surfaceContainerLowest = CampGroundColor.PaleGray,
)

val LocalDarkTheme = compositionLocalOf { true }

@Composable
fun CampGroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    if (!LocalInspectionMode.current) {
        val view = LocalView.current
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalDarkTheme provides darkTheme,
        LocalTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object CampGroundTheme {
    val typography: CampGroundTypography
        @Composable
        get() = LocalTypography.current
}