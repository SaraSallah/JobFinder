import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT_LIBRARY)
    id(Plugins.NAVIGATION_ARGS)
    id(Plugins.SERIALIZATION)
}

android {
    namespace = "com.example.jobfinder"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.jobfinder"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation("androidx.leanback:leanback:1.0.0")
    Dependencies.firebaseDependency.forEach { implementation(it) }
    Dependencies.uiDependencies.forEach { implementation(it) }
    Dependencies.composeDependency.forEach { implementation(it) }
    Dependencies.ktorDependency.forEach { implementation(it) }
    testImplementation(Dependencies.junitDependency)
    Dependencies.androidTestDependencies.forEach { androidTestImplementation(it) }
    implementation(platform(Dependencies.composePlatformBom))
    androidTestImplementation(platform(Dependencies.composePlatformBomAndroidTest))
    //Navigation
    Dependencies.navigationDependencies.forEach { implementation(it) }
    //Glide
    implementation(Dependencies.glideDependency)
    //Hilt
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltDependency)
    //LiveData
    Dependencies.liveDataDependencies.forEach { implementation(it) }
    //retrofit
    Dependencies.retrofitDependencies.forEach { implementation(it) }
    //swipe
    implementation(Dependencies.swipeDependency)
    // coil
    implementation(Dependencies.coilDependency)
    //splash
    implementation(Dependencies.splashDependency)
    debugImplementation(Dependencies.composeUiDependency)
    val retrofit = "2.9.0"
    val rxJava = "3.0.2"

    implementation ("com.squareup.retrofit2:retrofit:$retrofit")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation ("com.squareup.retrofit2:adapter-rxjava3:$retrofit")

    // rxJava dependency
    implementation ("io.reactivex.rxjava3:rxandroid:$rxJava")
    implementation ("io.reactivex.rxjava3:rxandroid:$rxJava")
    // Add other dependencies as needed

    //navigation
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("androidx.navigation:navigation-compose:2.6.0")

    // FCM notification
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-messaging-ktx")



    //paging
    implementation(Dependencies.pagingCommon)
    implementation(Dependencies.pagingRuntime)
    implementation(Dependencies.pagingCompose)

    //Permission
    implementation("com.google.accompanist:accompanist-permissions:0.28.0")
}
