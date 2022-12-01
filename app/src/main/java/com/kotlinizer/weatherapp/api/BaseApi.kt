package com.kotlinizer.weatherapp.api

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

abstract class BaseApi<T> {

	companion object {
		private const val TIME_OUT = 60_000
		private const val TAG = "WeatherApi"
	}

	private val client = HttpClient(Android) {
		engine {
			connectTimeout = TIME_OUT
			socketTimeout = TIME_OUT
		}
		install(ContentNegotiation) {
			json(Json {
				prettyPrint = true
				isLenient = true
				ignoreUnknownKeys = true
			})
		}
		install(Logging) {
			logger = object : Logger {
				override fun log(message: String) {
					Log.v(TAG, message)
				}
			}
			level = LogLevel.ALL
		}
	}

	protected suspend fun getRequest(url: String): HttpResponse? {
		try {
			return client.get(url)
		} catch (ex: java.lang.Exception) {
			Log.e(TAG, ex.message ?: "Error")
		}
		return null
	}

	abstract suspend fun fetch(): T?
}