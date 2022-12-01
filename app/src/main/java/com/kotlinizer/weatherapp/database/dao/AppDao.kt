package com.kotlinizer.weatherapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlinizer.weatherapp.entities.WeatherData
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun storeWeatherData(weatherData: WeatherData): Long?

	@Query("SELECT * FROM weatherData")
	fun getAllWeatherDataFlowable(): Flow<List<WeatherData?>?>
}