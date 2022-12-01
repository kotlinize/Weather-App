package com.kotlinizer.weatherapp.worker

import android.util.Log
import com.kotlinizer.base.interfaces.ApplicationContext
import com.kotlinizer.dependencyInjection.IDependencyInjector
import com.kotlinizer.weatherapp.util.isNetworkConnected
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

abstract class BaseWorker<T>(private val injector: IDependencyInjector) {

	private val manager by lazy { injector.resolve(WorkerManager::class.java)!! }
	private val applicationContext by lazy { injector.resolve(ApplicationContext::class.java)!! }

	protected val isNetworkConnected: Boolean
		get() = applicationContext.context.isNetworkConnected
	protected val scope: CoroutineScope
		get() = manager.coroutineScope
	protected val supervisor: Job
		get() = manager.supervisor

	protected val tag: String
		get() = this.javaClass.simpleName

	protected var actionOnFailure: ((ex: Exception) -> Unit)? = null
	protected var actionIfUnsuccessful: ((message: String) -> Unit)? = null

	/**
	 * Executes the Worker Operation.
	 *
	 * @return A [Job] that executes
	 */
	abstract suspend fun run()

	protected suspend inline fun doOnNetwork(action: () -> Unit) {
		try {
			Log.d(tag, "Attempting to Execute Operation on Network")
			var waitTime = 0
			while (!isNetworkConnected) {
				delay(1000)
				waitTime += 1
				Log.d(tag, "Network Unavailable - Retrying Operation #($waitTime)")
				if (waitTime >= 30) {
					Log.d(tag, "Network Unavailable - Ending Operation")
					actionIfUnsuccessful?.invoke("Network Unavailable")
					return
				}
			}
			Log.d(tag, "Operation Complete")
			action.invoke()
		} catch (ex: Exception) {
			Log.d(tag, "Execution Failed - ${ex.message}")
			actionOnFailure?.invoke(ex)
		}
	}

	fun onFailure(action: (ex: Exception) -> Unit): BaseWorker<T> {
		actionOnFailure = action
		return this
	}

	fun ifUnsuccessful(action: (message: String) -> Unit): BaseWorker<T> {
		actionIfUnsuccessful = action
		return this
	}
}