package com.kotlinizer.weatherapp

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinizer.dependencyInjection.Injector
import com.kotlinizer.weatherapp.database.repo.WeatherDataRepo
import com.kotlinizer.weatherapp.entities.WeatherData
import com.kotlinizer.weatherapp.worker.FetchSaveWeatherWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

	val weatherData = mutableStateOf<WeatherData?>(null)
	private val injector by lazy { Injector.instance }
	private val weatherDataRepo by lazy { injector.resolve(WeatherDataRepo::class.java)!! }
	private val fetchSaveWeatherWorker by lazy { FetchSaveWeatherWorker(injector) }

	init {
		weatherDataRepo.getFlow().onEach { it?.let { weatherData.value = it } }
			.catch { Log.e(this.javaClass.simpleName, it.message ?: "Error on WeatherDataFlow") }
			.launchIn(viewModelScope)

		viewModelScope.launch {
			delay(2000)
			refresh()
		}
	}

	suspend fun refresh() {
		withContext(Dispatchers.IO) {
			fetchSaveWeatherWorker.onFailure {
				Log.e(this.javaClass.simpleName, "Error On Weather Worker")
			}.run()
		}
	}
}