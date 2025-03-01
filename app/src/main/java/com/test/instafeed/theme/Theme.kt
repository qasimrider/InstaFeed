package com.test.instafeed.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.test.instafeed.ui.theme.DarkColors.backgroundDark
import com.test.instafeed.ui.theme.DarkColors.errorContainerDark
import com.test.instafeed.ui.theme.DarkColors.errorDark
import com.test.instafeed.ui.theme.DarkColors.inverseOnSurfaceDark
import com.test.instafeed.ui.theme.DarkColors.inversePrimaryDark
import com.test.instafeed.ui.theme.DarkColors.inverseSurfaceDark
import com.test.instafeed.ui.theme.DarkColors.onBackgroundDark
import com.test.instafeed.ui.theme.DarkColors.onErrorContainerDark
import com.test.instafeed.ui.theme.DarkColors.onErrorDark
import com.test.instafeed.ui.theme.DarkColors.onPrimaryContainerDark
import com.test.instafeed.ui.theme.DarkColors.onPrimaryDark
import com.test.instafeed.ui.theme.DarkColors.onSecondaryContainerDark
import com.test.instafeed.ui.theme.DarkColors.onSecondaryDark
import com.test.instafeed.ui.theme.DarkColors.onSurfaceDark
import com.test.instafeed.ui.theme.DarkColors.onSurfaceVariantDark
import com.test.instafeed.ui.theme.DarkColors.onTertiaryContainerDark
import com.test.instafeed.ui.theme.DarkColors.onTertiaryDark
import com.test.instafeed.ui.theme.DarkColors.outlineDark
import com.test.instafeed.ui.theme.DarkColors.outlineVariantDark
import com.test.instafeed.ui.theme.DarkColors.primaryContainerDark
import com.test.instafeed.ui.theme.DarkColors.primaryDark
import com.test.instafeed.ui.theme.DarkColors.scrimDark
import com.test.instafeed.ui.theme.DarkColors.secondaryContainerDark
import com.test.instafeed.ui.theme.DarkColors.secondaryDark
import com.test.instafeed.ui.theme.DarkColors.surfaceBrightDark
import com.test.instafeed.ui.theme.DarkColors.surfaceContainerDark
import com.test.instafeed.ui.theme.DarkColors.surfaceContainerHighDark
import com.test.instafeed.ui.theme.DarkColors.surfaceContainerHighestDark
import com.test.instafeed.ui.theme.DarkColors.surfaceContainerLowDark
import com.test.instafeed.ui.theme.DarkColors.surfaceContainerLowestDark
import com.test.instafeed.ui.theme.DarkColors.surfaceDark
import com.test.instafeed.ui.theme.DarkColors.surfaceDimDark
import com.test.instafeed.ui.theme.DarkColors.surfaceVariantDark
import com.test.instafeed.ui.theme.DarkColors.tertiaryContainerDark
import com.test.instafeed.ui.theme.DarkColors.tertiaryDark
import com.test.instafeed.ui.theme.LightColors.backgroundLight
import com.test.instafeed.ui.theme.LightColors.errorContainerLight
import com.test.instafeed.ui.theme.LightColors.errorLight
import com.test.instafeed.ui.theme.LightColors.inverseOnSurfaceLight
import com.test.instafeed.ui.theme.LightColors.inversePrimaryLight
import com.test.instafeed.ui.theme.LightColors.inverseSurfaceLight
import com.test.instafeed.ui.theme.LightColors.onBackgroundLight
import com.test.instafeed.ui.theme.LightColors.onErrorContainerLight
import com.test.instafeed.ui.theme.LightColors.onErrorLight
import com.test.instafeed.ui.theme.LightColors.onPrimaryContainerLight
import com.test.instafeed.ui.theme.LightColors.onPrimaryLight
import com.test.instafeed.ui.theme.LightColors.onSecondaryContainerLight
import com.test.instafeed.ui.theme.LightColors.onSecondaryLight
import com.test.instafeed.ui.theme.LightColors.onSurfaceLight
import com.test.instafeed.ui.theme.LightColors.onSurfaceVariantLight
import com.test.instafeed.ui.theme.LightColors.onTertiaryContainerLight
import com.test.instafeed.ui.theme.LightColors.onTertiaryLight
import com.test.instafeed.ui.theme.LightColors.outlineLight
import com.test.instafeed.ui.theme.LightColors.outlineVariantLight
import com.test.instafeed.ui.theme.LightColors.primaryContainerLight
import com.test.instafeed.ui.theme.LightColors.primaryLight
import com.test.instafeed.ui.theme.LightColors.scrimLight
import com.test.instafeed.ui.theme.LightColors.secondaryContainerLight
import com.test.instafeed.ui.theme.LightColors.secondaryLight
import com.test.instafeed.ui.theme.LightColors.surfaceBrightLight
import com.test.instafeed.ui.theme.LightColors.surfaceContainerHighLight
import com.test.instafeed.ui.theme.LightColors.surfaceContainerHighestLight
import com.test.instafeed.ui.theme.LightColors.surfaceContainerLight
import com.test.instafeed.ui.theme.LightColors.surfaceContainerLowLight
import com.test.instafeed.ui.theme.LightColors.surfaceContainerLowestLight
import com.test.instafeed.ui.theme.LightColors.surfaceDimLight
import com.test.instafeed.ui.theme.LightColors.surfaceLight
import com.test.instafeed.ui.theme.LightColors.surfaceVariantLight
import com.test.instafeed.ui.theme.LightColors.tertiaryContainerLight
import com.test.instafeed.ui.theme.LightColors.tertiaryLight


private val darkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)


private val lightColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

@Composable
fun InstaFeedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}