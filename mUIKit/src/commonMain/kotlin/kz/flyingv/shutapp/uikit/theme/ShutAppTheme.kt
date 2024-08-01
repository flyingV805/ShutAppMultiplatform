package kz.flyingv.shutapp.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val darkColorScheme = darkColors(
    primary = primary,
    primaryVariant = primaryVariant,
)

private val lightColorScheme = lightColors(
    primary = primary,
    primaryVariant = primaryVariant,
)

@Composable
fun ShutAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColorScheme: Colors? = null,
    content: @Composable () -> Unit
){

    val colorScheme = dynamicColorScheme ?: if(darkTheme){darkColorScheme}else{lightColorScheme}

    MaterialTheme(
        colors = colorScheme,
        content = content
    )

}