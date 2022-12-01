package com.kotlinizer.weatherapp.database.typeConverters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kotlinizer.base.interfaces.TypeConverter
import com.kotlinizer.weatherapp.entities.City

class CityTypeConverter : TypeConverter<City, String> {

	@androidx.room.TypeConverter
	override fun toDatabase(obj: City?): String? {
		return if (obj != null) Gson().toJson(obj) else null
	}

	@androidx.room.TypeConverter
	override fun fromDatabase(obj: String?): City? {
		val type = object : TypeToken<City>() {}.type
		return if (obj != null) Gson().fromJson(obj, type) else null
	}
}