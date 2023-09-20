import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT_LIBRARY)
    id(Plugins.SERIALIZATION)
}

android {
    namespace = "com.example.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(Dependencies.coreKtxDependency)
    implementation("androidx.paging:paging-common-ktx:3.2.0")
    testImplementation(Dependencies.junitDependency)
    Dependencies.androidTestDependencies.forEach { androidTestImplementation(it) }
    implementation(platform(Dependencies.composePlatformBom))
    androidTestImplementation(platform(Dependencies.composePlatformBomAndroidTest))
    //retrofit
    Dependencies.retrofitDependencies.forEach { implementation(it) }
    //Coroutine
    implementation(Dependencies.coroutinesDependency)
    //Hilt
    implementation(Dependencies.hiltDependency)
    kapt(Dependencies.hiltCompiler)
    // DataStore
    implementation(Dependencies.dateStoreDependency)
    Dependencies.ktorDependency.forEach { implementation(it) }

}
kapt {
    correctErrorTypes = true
}