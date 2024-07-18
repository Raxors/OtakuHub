package presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import otakuhub.composeapp.generated.resources.Res
import otakuhub.composeapp.generated.resources.roboto_bold
import otakuhub.composeapp.generated.resources.roboto_light
import otakuhub.composeapp.generated.resources.roboto_medium
import otakuhub.composeapp.generated.resources.roboto_regular

@Composable
fun AppFontFamyly() = FontFamily(
    Font(Res.font.roboto_light, weight = FontWeight.Light),
    Font(Res.font.roboto_regular, weight = FontWeight.Normal),
    Font(Res.font.roboto_medium, weight = FontWeight.Medium),
    Font(Res.font.roboto_bold, weight = FontWeight.Bold)
)

// Default Material 3 typography values
val baseline = Typography()

@Composable
fun AppTypography() = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = AppFontFamyly()),
    displayMedium = baseline.displayMedium.copy(fontFamily = AppFontFamyly()),
    displaySmall = baseline.displaySmall.copy(fontFamily = AppFontFamyly()),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = AppFontFamyly()),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = AppFontFamyly()),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = AppFontFamyly()),
    titleLarge = baseline.titleLarge.copy(fontFamily = AppFontFamyly()),
    titleMedium = baseline.titleMedium.copy(fontFamily = AppFontFamyly()),
    titleSmall = baseline.titleSmall.copy(fontFamily = AppFontFamyly()),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = AppFontFamyly()),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = AppFontFamyly()),
    bodySmall = baseline.bodySmall.copy(fontFamily = AppFontFamyly()),
    labelLarge = baseline.labelLarge.copy(fontFamily = AppFontFamyly()),
    labelMedium = baseline.labelMedium.copy(fontFamily = AppFontFamyly()),
    labelSmall = baseline.labelSmall.copy(fontFamily = AppFontFamyly()),
)

