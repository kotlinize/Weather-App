package com.kotlinizer.weatherapp.database.typeConverters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kotlinizer.base.interfaces.TypeConverter
import com.kotlinizer.weatherapp.entities.WeatherDay
import java.lang.reflect.Type

class WeatherDayListTypeConverter : TypeConverter<List<WeatherDay>, String> {

	@androidx.room.TypeConverter
	override fun toDatabase(obj: List<WeatherDay>?): String? {
		return Gson().toJson(obj)
	}

	@androidx.room.TypeConverter
	override fun fromDatabase(obj: String?): List<WeatherDay>? {
		val listType: Type = object : TypeToken<ArrayList<WeatherDay>>() {}.type
		return Gson().fromJson(obj, listType)
	}

}