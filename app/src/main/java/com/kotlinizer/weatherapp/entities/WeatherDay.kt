package com.kotlinizer.weatherapp.entities

import com.kotlinizer.weatherapp.util.TimeOfDay
import com.kotlinizer.weatherapp.util.timeOfDay
import kotlinx.serialization.SerialName
import java.util.*

@kotlinx.serialization.Serializable
data class WeatherDay(
	val dt: Long,
	val sunrise: Long,
	val sunset: Long,
	val temp: Temp,
	@SerialName("feels_like")
	val feelsLike: FeelsLike,
	val pressure: Int,
	val humidity: Int,
	@SerialName("weather")
	val weatherList: List<SimpleWeather>,
	val speed: Double?,
	val deg: Int?,
	val gust: Double?,
	val clouds: Int?,
	val pop: Double?,
	val rain: Double? = null
) {

	val date: Calendar
		get() = Calendar.getInstance(TimeZone.getTimeZone("EST")).apply {
			time = Date(dt * 1000) // Convert to Milliseconds
			timeZone = TimeZone.getDefault()
		}

	private val currentTime: Calendar
		get() = Calendar.getInstance(TimeZone.getTimeZone("EST"))

	val currentTemp: Int
		get() {
			return when (currentTime.timeOfDay) {
				TimeOfDay.MORNING -> temp.morn.toInt()
				TimeOfDay.DAY -> temp.day.toInt()
				TimeOfDay.EVENING -> temp.eve.toInt()
				TimeOfDay.NIGHT -> temp.night.toInt()
			}
		}

	val currentFeelsLikeTemp: Int
		get() {
			return when (currentTime.timeOfDay) {
				TimeOfDay.MORNING -> feelsLike.morn.toInt()
				TimeOfDay.DAY -> feelsLike.day.toInt()
				TimeOfDay.EVENING -> feelsLike.eve.toInt()
				TimeOfDay.NIGHT -> feelsLike.night.toInt()
			}
		}
}