object Dependencies {
    // App Ui Dependencies
    val uiDependencies by lazy {
        listOf(
            "androidx.core:core-ktx:${DependencyVersions.CORE_KTX}",
            "androidx.appcompat:appcompat:${DependencyVersions.APP_COMPAT}",
            "com.google.android.material:material:${DependencyVersions.MATERIAL}",
            "androidx.constraintlayout:constraintlayout:${DependencyVersions.CONSTRAINT_LAYOUT}",
            "com.airbnb.android:lottie:${DependencyVersions.LOTTIE}",
            "androidx.slidingpanelayout:slidingpanelayout:${DependencyVersions.SLIDE_PANE}"
        )
    }
    val coreKtxDependency by lazy { "androidx.core:core-ktx:${DependencyVersions.CORE_KTX}" }
    val dataBindingDependency by lazy { "androidx.databinding:databinding-runtime:${DependencyVersions.DATA_BINDING}" }

    // Test Dependencies
    val junitDependency by lazy { "junit:junit:${DependencyVersions.JUNIT}" }
    val androidTestDependencies by lazy {
        listOf(
            "androidx.test.espresso:espresso-core:${DependencyVersions.ESPRESSO}",
            "androidx.test.ext:junit:${DependencyVersions.ANDROID_JUNIT}",
            "androidx.compose.ui:ui-test-junit4"
        )
    }
    val debugmplementation by lazy {
        listOf(
            "androidx.compose.ui:ui-tooling",
            "androidx.compose.ui:ui-test-manifest"
        )
    }

    // navigation
    val navigationDependencies by lazy {
        listOf(
            "androidx.navigation:navigation-fragment-ktx:${DependencyVersions.ANDROID_NAVIGATION_FRAGMENT}",
            "androidx.navigation:navigation-ui-ktx:${DependencyVersions.ANDROID_NAVIGATION_UI}"
        )
    }

    // Networking Dependencies
    val retrofitDependencies by lazy {
        listOf(
            "com.squareup.retrofit2:retrofit:${DependencyVersions.RETROFIT}",
            "com.squareup.retrofit2:converter-gson:${DependencyVersions.RETROFIT}",
            "com.squareup.okhttp3:logging-interceptor:${DependencyVersions.OKHTTP_INTERCEPTOR}",
            "com.google.code.gson:gson:${DependencyVersions.GSON}"
        )
    }
    val glideDependency by lazy {
        "com.github.bumptech.glide:glide:${DependencyVersions.GLIDE}"
    }

    // Coroutines Dependencies
    val coroutinesDependency by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersions.COROUTINES}"
    }

    // Live Data
    val liveDataDependencies by lazy {
        listOf(
            "androidx.lifecycle:lifecycle-livedata-ktx:${DependencyVersions.LIVE_DATA_LIFE_CYCLE}",
            "androidx.activity:activity-ktx:${DependencyVersions.LIVE_DATA_ACTIVITY}",
            "androidx.fragment:fragment-ktx:${DependencyVersions.LIVE_DATA_FRAGMENT}",
            "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersions.RUN_TIME_LIFECYCLE_COMPOSE}"
        )
    }

    // Hilt
    val hiltDependency by lazy {
        "com.google.dagger:hilt-android:${DependencyVersions.HILT}"
    }
    val hiltCompiler by lazy {
        "com.google.dagger:hilt-android-compiler:${DependencyVersions.HILT}"
    }
    val daggerAndroid by lazy {
        "com.google.dagger:dagger-android:${DependencyVersions.DAGGER_ANDROID}"
    }

    val swipeDependency by lazy {
        "it.xabaras.android:recyclerview-swipedecorator:${DependencyVersions.SWIPE}"
    }
    val coilDependency by lazy {
        "io.coil-kt:coil:${DependencyVersions.COIL}"
    }
    val dateStoreDependency by lazy {
        "androidx.datastore:datastore-preferences:${DependencyVersions.DATA_STORE}"
    }

    val composeDependency by lazy {
        listOf(
            "androidx.compose.material3:material3:${DependencyVersions.MATERIAL3_COMPOSE}",
            "androidx.activity:activity-compose:${DependencyVersions.ACTIVITY_COMPOSE}",
            "androidx.compose.ui:ui",
            "androidx.compose.ui:ui-graphics",
            "androidx.compose.ui:ui-tooling-preview",
            "androidx.compose.foundation:foundation:${DependencyVersions.FOUNDATION_COMPOSE}",
            "androidx.compose.ui:ui-util:${DependencyVersions.UI_UTIL_COMPOSE}",
            "androidx.constraintlayout:constraintlayout-compose:${DependencyVersions.CONSTRAINT_LAYOUT_COMPOSE}",
            "com.google.accompanist:accompanist-systemuicontroller:${DependencyVersions.SYSTEM_UI_CONTROLLER}",
            "io.coil-kt:coil-compose:${DependencyVersions.COIL_COMPOSE}",
            "androidx.appcompat:appcompat:1.3.0-beta01",
            "androidx.hilt:hilt-navigation-compose:${DependencyVersions.HILT_COMPOSE}",
            "com.airbnb.android:lottie-compose:${DependencyVersions.LOTTIE_COMPOSE}",
            "androidx.compose.material:material:${DependencyVersions.MATERIAL_COMPOSE}",
            "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersions.RUN_TIME_LIFECYCLE_COMPOSE}"
        )
    }
    val ktorDependency by lazy {
        listOf(
            "io.ktor:ktor-client-core:${DependencyVersions.KTOR_VERSION}",
            "io.ktor:ktor-client-android:${DependencyVersions.KTOR_VERSION}",
            "io.ktor:ktor-client-okhttp:${DependencyVersions.KTOR_VERSION}",
            "io.ktor:ktor-client-content-negotiation:${DependencyVersions.KTOR_VERSION}",
            "io.ktor:ktor-client-serialization:${DependencyVersions.KTOR_VERSION}",
            "io.ktor:ktor-serialization-gson:${DependencyVersions.KTOR_VERSION}",
            "io.ktor:ktor-client-logging-jvm:${DependencyVersions.KTOR_LOGGING}",
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${DependencyVersions.KTOR_SERIALIZATION}",
            "com.squareup.okhttp3:logging-interceptor:${DependencyVersions.OKHTTP_INTERCEPTOR}",
        )
    }

    val splashDependency by lazy {
        "androidx.core:core-splashscreen:${DependencyVersions.SPLASH_SCREEN}"
    }

    val firebaseDependency by lazy {
        listOf(
            "com.google.firebase:firebase-crashlytics:${DependencyVersions.FIREBASE_CRASH}",
            "com.google.firebase:firebase-analytics:${DependencyVersions.FIREBASE_ANALYTICS}",
        )
    }
    val composeUiDependency by lazy {
        "androidx.compose.ui:ui-tooling:${DependencyVersions.MATERIAL_COMPOSE}"
    }
    val composePlatformBom by lazy {
        "androidx.compose:compose-bom:${DependencyVersions.PLATFORM_BOM_COMPOSE}"
    }
    val composePlatformBomAndroidTest by lazy {
        "androidx.compose:compose-bom:${DependencyVersions.PLATFORM_BOM_COMPOSE}"
    }

    // Paging
    val pagingRuntime by lazy {
        "androidx.paging:paging-runtime:${DependencyVersions.PagingRuntimeVersion}"
    }
    val pagingCompose by lazy {
        "androidx.paging:paging-compose:${DependencyVersions.PagingComposeVersion}"
    }
    val pagingCommon by lazy {
        "androidx.paging:paging-common:${DependencyVersions.PagingRuntimeVersion}"
    }

    object Classpath {

        val navigationClasspath by lazy {
            "androidx.navigation:navigation-safe-args-gradle-plugin:${DependencyVersions.ClasspathVersions.NAVIGATION_CLASSPATH}"
        }
        val toolsBuildClasspath by lazy {
            "com.android.tools.build:gradle:${DependencyVersions.ClasspathVersions.TOOLS_BUILD_CLASSPATH}"
        }
        val googleServiceClasspath by lazy {
            "com.google.gms:google-services:${DependencyVersions.ClasspathVersions.GOOGLE_SERVICES_CLASSPATH}"
        }
        val googleFirebaseCrashClasspath by lazy {
            "com.google.firebase:firebase-crashlytics-gradle:${DependencyVersions.ClasspathVersions.FIREBASE_CRASH_CLASSPATH}"
        }
        val kotlinSerializationClasspath by lazy {
            "org.jetbrains.kotlin:kotlin-serialization:${DependencyVersions.ClasspathVersions.KOTLIN_SERIALZATION_CLASSPATH}"
        }
    }

}
object DependencyVersions {
    // App Ui Dependencies
    const val APP_COMPAT = "1.6.1"
    const val CORE_KTX = "1.10.0"
    const val MATERIAL = "1.7.0"
    const val CONSTRAINT_LAYOUT = "2.1.4"
    const val LOTTIE = "6.0.0"
    const val SLIDE_PANE = "1.2.0-beta01"

    // Test Dependencies
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.5"
    const val ESPRESSO = "3.5.1"

    // navigation
    const val ANDROID_NAVIGATION_FRAGMENT = "2.5.3"
    const val ANDROID_NAVIGATION_UI = "2.5.3"

    // Networking Dependencies
    const val OKHTTP_INTERCEPTOR = "5.0.0-alpha.11"
    const val RETROFIT = "2.9.0"
    const val GLIDE = "4.15.1"
    const val GSON = "2.10.1"

    // Coroutines Dependencies
    const val COROUTINES = "1.6.4"

    // Live Data
    const val LIVE_DATA_LIFE_CYCLE = "2.6.1"
    const val LIVE_DATA_ACTIVITY = "1.3.1"
    const val LIVE_DATA_FRAGMENT = "1.3.6"
    const val HILT = "2.44"
    const val DATA_BINDING = "7.1.0"
    const val DAGGER_ANDROID = "2.35.1"
    const val SWIPE = "1.4"
    const val COIL = "2.2.2"
    const val DATA_STORE = "1.0.0"

    // compose
    const val RUN_TIME_LIFECYCLE_COMPOSE = "2.6.1"
    const val ACTIVITY_COMPOSE = "1.5.1"
    const val BOM_COMPOSE = "2022.10.00"
    const val FOUNDATION_COMPOSE = "1.4.3"
    const val UI_UTIL_COMPOSE = "1.4.3"
    const val CONSTRAINT_LAYOUT_COMPOSE = "1.0.1"
    const val SYSTEM_UI_CONTROLLER = "0.28.0"
    const val COIL_COMPOSE = "2.2.2"
    const val MATERIAL3_COMPOSE = "1.1.1"
    const val HILT_COMPOSE = "1.0.0"
    const val LOTTIE_COMPOSE = "6.0.0"
    const val MATERIAL_COMPOSE = "1.4.3"
    const val PLATFORM_BOM_COMPOSE = "2023.03.00"

    //ktor
    const val KTOR_VERSION = "2.3.2"
    const val KTOR_LOGGING= "1.5.0"
    const val KTOR_SERIALIZATION= "1.3.0"

    //firebase
    const val FIREBASE_CRASH= "18.4.0"
    const val FIREBASE_ANALYTICS= "21.3.0"

    //splash
    const val SPLASH_SCREEN= "1.0.1"

    //paging
    const val PagingRuntimeVersion = "3.1.1"
    const val PagingComposeVersion = "3.2.0"


    object ClasspathVersions{
        const val NAVIGATION_CLASSPATH = "2.5.3"
        const val TOOLS_BUILD_CLASSPATH = "4.3.15"
        const val GOOGLE_SERVICES_CLASSPATH = "4.3.15"
        const val FIREBASE_CRASH_CLASSPATH = "2.9.7"
        const val KOTLIN_SERIALZATION_CLASSPATH = "1.8.10"
    }
}