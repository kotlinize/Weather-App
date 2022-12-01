
plugins {
	id(Plugins.Android.APPLICATION)
	id("org.jetbrains.kotlin.android")
	kotlin("plugin.serialization")
	id("kotlin-kapt")
}

android {
	compileSdk = Android.COMPILE_VERSION

	buildFeatures {
		viewBinding = true
		compose = true
	}

	composeOptions {
		kotlinCompilerExtensionVersion = Versions.Jetpack.Compose.COMPILER
	}

	defaultConfig {
		applicationId = Application.ID
		minSdk = Android.MIN_VERSION
		targetSdk = Android.TARGET_VERSION
		versionCode = Application.VERSION_CODE
		versionName = Application.VERSION_NAME

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
		jvmTarget = Android.JVM_TARGET
	}
}

dependencies {
	// Project Dependencies
	implementation(project(Modules.BASE))

	// Library Dependencies
	implementation(Dependencies.AndroidX.CORE)
	implementation(Dependencies.AndroidX.APP_COMPAT)
	implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)

	implementation(Dependencies.Google.PLAY_SERVICES)
	implementation(Dependencies.Google.MATERIAL)

	implementation(Dependencies.Jetpack.Compose.UI)
	implementation(Dependencies.Jetpack.Compose.UI_TOOLING)
	implementation(Dependencies.Jetpack.Compose.FOUNDATION)
	implementation(Dependencies.Jetpack.Compose.MATERIAL)
	implementation(Dependencies.Jetpack.Compose.MATERIAL_ICONS)
	implementation(Dependencies.Jetpack.Compose.MATERIAL_ICONS_EXTENDED)
	implementation(Dependencies.Jetpack.Compose.ACTIVITY)
	implementation(Dependencies.Jetpack.Compose.VIEW_MODEL)
	implementation(Dependencies.Jetpack.Compose.ANIMATION)

	implementation("io.ktor:ktor-client-android:2.1.2")
	implementation("io.ktor:ktor-client-serialization:2.1.2")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
	implementation("io.ktor:ktor-client-logging-jvm:2.1.2")
	implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.2")
	implementation("io.ktor:ktor-client-content-negotiation:2.1.2")

	implementation("androidx.room:room-runtime:2.4.3")
	kapt("androidx.room:room-compiler:2.4.3")

	implementation("androidx.room:room-ktx:2.4.3")
	implementation("com.google.code.gson:gson:2.8.9")

	implementation(Dependencies.Kotlinizer.DEPENDENCY_INJECTION)

	// Test Dependencies
	testImplementation(Dependencies.Test.JUNIT)

	// Android Test Dependencies
	androidTestImplementation(Dependencies.Jetpack.Compose.UI_TEST)
	androidTestImplementation(Dependencies.Test.EXT_JUNIT)
	androidTestImplementation(Dependencies.Test.ESPRESSO)
}