package com.kotlinizer.weatherapp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Light Color Palette for Day/Light Theme.
 */
val lightThemeColors = lightColors(
	primary = ComposeColors.DENIM,
	primaryVariant = ComposeColors.FRENCH_GRAY,
	secondary = ComposeColors.MID_GRAY,
	secondaryVariant = ComposeColors.MID_GRAY,
	background = ComposeColors.GALLERY_GRAY,
	surface = ComposeColors.WILD_SAND,
	error = ComposeColors.PERSIAN_RED,
	onPrimary = Color.White,
	onSecondary = Color.White,
	onBackground = Color(0xFF003459),
	onSurface = Color.Black,
	onError = Color.White
)

/**
 * Dark Color Palette for Night/Dark Theme.
 */
val darkThemeColors = darkColors(
	primary = ComposeColors.MALIBU,
	primaryVariant = ComposeColors.TUNA,
	secondary = ComposeColors.BOMBAY,
	secondaryVariant = ComposeColors.BOMBAY,
	background = ComposeColors.SHARK,
	surface = Color.Black,
	error = ComposeColors.PERSIMMON,
	onPrimary = Color.Black,
	onSecondary = Color.White,
	onBackground = Color.White,
	onSurface = Color.White,
	onError = Color.Black
)

/**
 * Button Colors for Standard Carfax Material Themed Buttons.
 */
val buttonColors: ButtonColors
	@Composable get() = ButtonDefaults.buttonColors(
		backgroundColor = MaterialTheme.colors.primary, contentColor = MaterialTheme.colors.background
	)

/**
 * Button Elevation for Standard Carfax Material Themed Buttons.
 */
val buttonElevation: ButtonElevation
	@Composable get() = ButtonDefaults.elevation(defaultElevation = 3.dp, pressedElevation = 0.dp)

/**
 * Standard App Theme Typography.
 */
val typography = Typography(
	defaultFontFamily = FontFamily.Default, h1 = TextStyle(
		fontWeight = FontWeight.Light, fontSize = 96.sp, letterSpacing = (-1.5).sp
	), h2 = TextStyle(
		fontWeight = FontWeight.Light, fontSize = 60.sp, letterSpacing = (-0.5).sp
	), h3 = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 48.sp, letterSpacing = 0.sp
	), h4 = TextStyle(
		fontWeight = FontWeight.Bold, fontSize = 32.sp, letterSpacing = 0.25.sp
	), h5 = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 24.sp, letterSpacing = 0.sp
	), h6 = TextStyle(
		fontWeight = FontWeight.Medium, fontSize = 20.sp, letterSpacing = 0.15.sp
	), subtitle1 = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 16.sp, letterSpacing = 0.15.sp
	), subtitle2 = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 14.sp, letterSpacing = 0.1.sp
	), body1 = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 16.sp, letterSpacing = 0.15.sp
	), body2 = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 14.sp, letterSpacing = 0.25.sp
	), button = TextStyle(
		fontWeight = FontWeight.Medium, fontSize = 14.sp, letterSpacing = 1.25.sp
	), caption = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 12.sp, letterSpacing = 0.4.sp
	), overline = TextStyle(
		fontWeight = FontWeight.Normal, fontSize = 10.sp, letterSpacing = 1.5.sp
	)
)

/**
 * Weather App Theme that encapsulates the Color Scheme, Typography and Shapes.
 */
@Composable fun WeatherAppTheme(
	content: @Composable () -> Unit
) {
	val colors = if (isSystemInDarkTheme()) {
		darkThemeColors
	} else {
		lightThemeColors
	}

	MaterialTheme(
		colors = colors, typography = typography, content = content
	)
}