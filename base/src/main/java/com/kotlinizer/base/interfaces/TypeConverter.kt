package com.kotlinizer.base.interfaces

/**
 * The Type Converter Interface require to transform objects to SQL types and back to its original form.
 */
interface TypeConverter<T, S> {

	/**
	 * Converts a [T] object into a [S] object to store into a database.
	 *
	 * @param obj The object [T] to convert to a [S].
	 * @return A [S] to store into a database.
	 */
	fun toDatabase(obj: T?): S?

	/**
	 * Converts a [T] object into a [S] object to retrieve from a database.
	 *
	 * @param obj The object [S] to convert to a [T].
	 * @return A [T] to retrieve from a database.
	 */
	fun fromDatabase(obj: S?): T?
}