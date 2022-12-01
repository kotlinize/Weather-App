// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
	repositories {
		google()
		mavenCentral()
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.Kotlin.kotlin}")
	}
}

plugins {
	id("com.android.application") version "7.3.0" apply false
	id("com.android.library") version "7.3.0" apply false
	id("org.jetbrains.kotlin.android") version "1.7.20" apply false
}