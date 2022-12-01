package com.kotlinizer.weatherapp.util

import java.util.*

val Calendar.dayOfWeek: String
	get() = DayOfWeek.values()[this.get(Calendar.DAY_OF_WEEK) - 1].displayName

val Calendar.hourOfDay: Int
	get() = this.get(Calendar.HOUR_OF_DAY)

val Calendar.timeOfDay: TimeOfDay
	get() {
		return when (this.hourOfDay) {
			in 22..24,
			in 0..3 -> TimeOfDay.NIGHT
			in 4..9 -> TimeOfDay.MORNING
			in 10..16 -> TimeOfDay.DAY
			else -> TimeOfDay.EVENING
		}
	}