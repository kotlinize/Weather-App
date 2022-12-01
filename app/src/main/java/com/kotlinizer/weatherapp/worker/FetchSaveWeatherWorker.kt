package com.kotlinizer.weatherapp.worker

import com.kotlinizer.dependencyInjection.IDependencyInjector
import com.kotlinizer.weatherapp.api.WeatherAppApi
import com.kotlinizer.weatherapp.database.repo.WeatherDataRepo
import com.kotlinizer.weatherapp.entities.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchSaveWeatherWorker(injector: IDependencyInjector) : BaseWorker<WeatherData?>(injector) {

	private val weatherAppApi by lazy { WeatherAppApi() }
	private val weatherDataRepo by lazy { injector.resolve(WeatherDataRepo::class.java)!! }

	override suspend fun run() = withContext(Dispatchers.IO) {
		doOnNetwork {
			weatherAppApi.fetch()?.let {
				weatherDataRepo.store(it)
			}
		}
	}
}