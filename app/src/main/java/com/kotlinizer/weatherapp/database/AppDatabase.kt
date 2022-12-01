package com.kotlinizer.weatherapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kotlinizer.weatherapp.database.dao.AppDao
import com.kotlinizer.weatherapp.database.typeConverters.CityTypeConverter
import com.kotlinizer.weatherapp.database.typeConverters.WeatherDataListTypeConverter
import com.kotlinizer.weatherapp.database.typeConverters.WeatherDayListTypeConverter
import com.kotlinizer.weatherapp.entities.WeatherData

@Database(
	entities = [WeatherData::class],
	version = 1,
	exportSchema = false
)
@TypeConverters(
	CityTypeConverter::class,
	WeatherDataListTypeConverter::class,
	WeatherDayListTypeConverter::class
)
internal abstract class AppDatabase : RoomDatabase() {

	companion object {
		@Volatile
		private var instance: AppDatabase? = null
		private val lock = Any()

		operator fun invoke(context: Context) = instance ?: synchronized(lock) {
			instance ?: buildDatabase(context).also { instance = it }
		}

		private fun buildDatabase(context: Context) = Room.databaseBuilder(
			context,
			AppDatabase::class.java,
			"AppDatabase"
		)
			.fallbackToDestructiveMigration()
			.build()
	}

	abstract fun appDao(): AppDao
}