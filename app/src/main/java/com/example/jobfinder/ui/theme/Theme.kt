package com.example.jobfinder.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val localDimens = compositionLocalOf { Dimens() }

private val DarkColorScheme = darkColorScheme(
    primaryContainer = darkBackground400,
    primary = primary100,
//    inverseSurface = primary16,
    surface = grey,
    onPrimary = darkText87,
    secondary = darkBackground200,
    onSecondary = white,
    background = darkBackground200,
    onBackground = black60,
    error = darkError,
    secondaryContainer = darkBackground400,
    onSecondaryContainer = darkText37,
    tertiary = darkBackground400,
    onTertiary = darkBackground300,
    onTertiaryContainer = black37,
    tertiaryContainer = darkBackground300,
    onSurfaceVariant = blackOn60,
    errorContainer = darkBackground400,
    inverseOnSurface = darkBackground300,
    onError = primary100,
    onErrorContainer = black37,
    outlineVariant = white,


    )

private val LightColorScheme = lightColorScheme(
    primaryContainer = white,
    primary = primary100,
//    inverseSurface = primary16,
    surface = white,
    onPrimary = white,
    secondary = white,
    onSecondary = black87,
    background = background,
    onBackground = black60,
//    error = kotlin.error,
    secondaryContainer = white100,
    onSecondaryContainer = black37,
    tertiary = white,
    onTertiary = white,
    onTertiaryContainer = black16,
    tertiaryContainer = white30,
    onSurfaceVariant = white87,
    errorContainer = primary100,
    inverseOnSurface = primary100,
    onError = white,
    onErrorContainer = primary100,
    outlineVariant = black8,

    )



    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */


val MaterialTheme.dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = localDimens.current

@Composable
fun JobFinderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme


    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(localDimens provides Dimens()) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}