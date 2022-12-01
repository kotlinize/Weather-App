package com.kotlinizer.weatherapp.database.repo

import com.kotlinizer.weatherapp.entities.WeatherData
import com.kotlinizer.weatherapp.database.dao.AppDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class WeatherDataRepo(private val dao: AppDao): Repository<WeatherData> {

	override suspend fun store(data: WeatherData): Boolean {
		return dao.storeWeatherData(data) != null
	}

	override fun getFlow(): Flow<WeatherData?> {
		return dao.getAllWeatherDataFlowable().map { it?.firstOrNull() }
	}
}