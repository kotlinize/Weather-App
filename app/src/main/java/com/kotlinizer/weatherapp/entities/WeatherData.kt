package com.kotlinizer.weatherapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Transient

@kotlinx.serialization.Serializable
@Entity(tableName = "weatherData")
data class WeatherData(
	@PrimaryKey val id: Long = -1,
	@Transient var updateTime: Long = -1,
	var city: City? = null,
	var list: List<WeatherDay> = listOf()
)