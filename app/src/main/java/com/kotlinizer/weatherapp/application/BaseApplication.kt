package com.kotlinizer.weatherapp.application

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.kotlinizer.base.interfaces.ApplicationContext
import com.kotlinizer.base.interfaces.Toaster
import com.kotlinizer.dependencyInjection.Injector
import com.kotlinizer.weatherapp.database.AppDatabase
import com.kotlinizer.weatherapp.database.repo.WeatherDataRepo

class BaseApplication : Application() {

	private val injector by lazy { Injector.instance }

	override fun onCreate() {
		super.onCreate()
		loadDependencies()
	}

	/**
	 * Load the required dependencies.
	 */
	private fun loadDependencies() {
		// Register the Application Context
		injector.register(
			type = ApplicationContext::class.java,
			provider = object : ApplicationContext {
				override val context: Context
					get() = applicationContext
			},
		)

		// Register the DAO and invoke the database
		val dao = AppDatabase.invoke(context = applicationContext).appDao()
		injector.register(WeatherDataRepo::class.java, WeatherDataRepo(dao))


		// Register the Toaster
		injector.register(type = Toaster::class.java, provider = object : Toaster {
			override fun makeLongToast(message: String) {
				Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
			}

			override fun makeShortToast(message: String) {
				Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
			}
		})
	}
}