package com.kotlinizer.weatherapp.theme

import androidx.compose.ui.graphics.Color

object ComposeColors {
	val DENIM = Color(0XFF1976D2)
	val MALIBU = Color(0XFF63A4FF)
	val PERSIAN_RED = Color(0XFFD32F2F)
	val PERSIMMON = Color(0XFFFF6659)
	val WILD_SAND = Color(0XFFF5F5F5)
	val GALLERY_GRAY = Color(0XFFEEEEEE)
	val FRENCH_GRAY = Color(0XFFC6C6C8)
	val MID_GRAY = Color(0XFF6C6C70)
	val BOMBAY = Color(0XFFAEAEB2)
	val SHARK = Color(0XFF1C1C1E)
	val TUNA = Color(0XFF38383A)
}

val Color.alpha10: Color
	get() = this.copy(alpha = 0.1f)
val Color.alpha20: Color
	get() = this.copy(alpha = 0.2f)
val Color.alpha30: Color
	get() = this.copy(alpha = 0.3f)
val Color.alpha40: Color
	get() = this.copy(alpha = 0.4f)
val Color.alpha50: Color
	get() = this.copy(alpha = 0.5f)
val Color.alpha60: Color
	get() = this.copy(alpha = 0.6f)
val Color.alpha70: Color
	get() = this.copy(alpha = 0.7f)
val Color.alpha80: Color
	get() = this.copy(alpha = 0.8f)
val Color.alpha90: Color
	get() = this.copy(alpha = 0.9f)

fun Color.alpha(value: Float): Color {
	return this.copy(alpha = value)
}