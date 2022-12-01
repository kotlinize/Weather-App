package com.kotlinizer.weatherapp.entities

import androidx.annotation.DrawableRes
import com.kotlinizer.weatherapp.R

@kotlinx.serialization.Serializable
data class SimpleWeather(
	val id: Int,
	val main: String,
	val description: String,
	val icon: String
) {

	@DrawableRes
	fun iconRes(): Int {
		return when (icon) {
			"11d" -> R.drawable.weather_stormy
			"09d" -> R.drawable.weather_rainy
			"10d", "13d" -> R.drawable.weather_rainy_2
			"01n" -> R.drawable.weather_moon
			"02d" -> R.drawable.weather_cloudy
			"02n" -> R.drawable.weather_cloudy_night
			else -> R.drawable.weather_sunny
		}
	}
}