package com.kotlinizer.weatherapp.worker

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class WorkerManager {

	val supervisor = SupervisorJob()

	private val handler = CoroutineExceptionHandler { _, throwable ->
		Log.e("WorkerManager", "Error thrown: ${throwable.message}")
	}

	val coroutineScope = CoroutineScope(Dispatchers.IO + supervisor + handler)
}