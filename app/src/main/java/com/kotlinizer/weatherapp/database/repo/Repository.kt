package com.kotlinizer.weatherapp.database.repo

import kotlinx.coroutines.flow.Flow

interface Repository<T> {

	suspend fun store(data: T): Boolean

	fun getFlow(): Flow<T?>

}