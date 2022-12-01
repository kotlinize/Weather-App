object Dependencies {

	object AndroidX {
		const val CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE}"
		const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APP_COMPAT}"
		const val CONSTRAINT_LAYOUT =
			"androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
	}

	object Google {
		const val PLAY_SERVICES = "com.google.android.gms:play-services-auth:${Versions.Google.PLAY_SERVICES}"
		const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
	}

	object Room {
		const val compiler = "androidx.room:room-compiler:${Versions.AndroidX.ROOM}"
		const val ktx = "androidx.room:room-ktx:${Versions.AndroidX.ROOM}"
		const val runtime = "androidx.room:room-runtime:${Versions.AndroidX.ROOM}"
	}

	object Jetpack {
		object Compose {
			const val UI = "androidx.compose.ui:ui:${Versions.Jetpack.Compose.VERSION}"
			const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Jetpack.Compose.VERSION}"
			const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.Jetpack.Compose.VERSION}"
			const val ACTIVITY = "androidx.activity:activity-compose:${Versions.Jetpack.Compose.ACTIVITY}"
			const val MATERIAL = "androidx.compose.material:material:${Versions.Jetpack.Compose.MATERIAL}"
			const val MATERIAL_ICONS =
				"androidx.compose.material:material-icons-core:${Versions.Jetpack.Compose.MATERIAL}"
			const val MATERIAL_ICONS_EXTENDED =
				"androidx.compose.material:material-icons-extended:${Versions.Jetpack.Compose.MATERIAL}"
			const val ANIMATION = "androidx.compose.animation:animation:${Versions.Jetpack.Compose.VERSION}"
			const val VIEW_MODEL =
				"androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Jetpack.Compose.VIEW_MODEL}"
			const val UI_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.Jetpack.Compose.VERSION}"
		}
	}

	object Kotlin {
		const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlin}"

		object Coroutines {
			const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}"
			const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutines}"
		}
	}

	object Kotlinizer {
		const val DEPENDENCY_INJECTION =
			"com.kotlinizer:dependency-injection:${Versions.Kotlinizer.DEPENDENCY_INJECTION}"
	}

	object Test {
		const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
		const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.Test.EXT_JUNIT}"
		const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
	}
}