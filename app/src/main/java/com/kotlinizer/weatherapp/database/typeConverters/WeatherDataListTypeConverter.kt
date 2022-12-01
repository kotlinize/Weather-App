package com.kotlinizer.weatherapp.database.typeConverters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kotlinizer.base.interfaces.TypeConverter
import com.kotlinizer.weatherapp.entities.WeatherData
import java.lang.reflect.Type

class WeatherDataListTypeConverter : TypeConverter<List<WeatherData>, String> {

	@androidx.room.TypeConverter
	override fun toDatabase(obj: List<WeatherData>?): String? {
		return Gson().toJson(obj)
	}

	@androidx.room.TypeConverter
	override fun fromDatabase(obj: String?): List<WeatherData>? {
		val listType: Type = object : TypeToken<ArrayList<WeatherData>>() {}.type
		return Gson().fromJson(obj, listType)
	}
}