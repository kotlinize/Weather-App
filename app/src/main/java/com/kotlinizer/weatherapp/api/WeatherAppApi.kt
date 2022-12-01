package com.kotlinizer.weatherapp.api

import com.kotlinizer.weatherapp.entities.WeatherData
import io.ktor.client.call.*

class WeatherAppApi : BaseApi<WeatherData>() {

	companion object {
		private const val URL =
			"https://api.openweathermap.org/data/2.5/forecast/daily?q=Atlanta&mode=json&cnt=7&units=imperial&apikey=3aa158b2f14a9f493a8c725f8133d704"
	}

	override suspend fun fetch(): WeatherData? {
		val requestTime = System.currentTimeMillis()
		val response = getRequest(URL)

		return (response?.body() as? WeatherData?)?.apply {
			updateTime = requestTime
		}?.copy(id = 1001)
	}
}