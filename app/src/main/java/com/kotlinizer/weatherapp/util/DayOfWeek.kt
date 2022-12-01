package com.kotlinizer.weatherapp.util

enum class DayOfWeek(val displayName: String) {
	SUNDAY("Sunday"),
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday");

	override fun toString(): String {
		return displayName
	}
}