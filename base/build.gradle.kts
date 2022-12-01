plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {
	compileSdk = Android.COMPILE_VERSION

	defaultConfig {
		minSdk = Android.MIN_VERSION
		targetSdk = Android.TARGET_VERSION

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
}

dependencies {
	// Library Dependencies
	implementation(Dependencies.AndroidX.CORE)
	implementation(Dependencies.AndroidX.APP_COMPAT)
	implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
}