package com.kotlinizer.base.interfaces

/**
 * Toaster Implementation for ease of use.
 */
interface Toaster {

	/**
	 * Makes a Toast of LENGTH-LONG.
	 *
	 * @param message The [String] value of the message to display.
	 */
	fun makeLongToast(message: String)

	/**
	 * Makes a Toast of LENGTH-SHORT.
	 *
	 * @param message The [String] value of the message to display.
	 */
	fun makeShortToast(message: String)
}