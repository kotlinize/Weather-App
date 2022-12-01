package com.kotlinizer.weatherapp.entities

@kotlinx.serialization.Serializable
data class FeelsLike(
	val day: Double,
	val night: Double,
	val eve: Double,
	val morn: Double
)
