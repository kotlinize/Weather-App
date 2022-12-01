package com.kotlinizer.weatherapp.entities

@kotlinx.serialization.Serializable
data class City(
	val id: Long,
	val name: String,
	val country: String,
	val population: Long,
	val timezone: Int
)
