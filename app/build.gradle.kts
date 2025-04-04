plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.ksp) // Apply KSP plugin
    alias(libs.plugins.hilt.android) // Apply Hilt plugin
//    alias(libs.plugins.kotlin.parcelize) // Apply if needed
    alias(libs.plugins.androidx.navigation.safeargs) // Apply if needed
    id("kotlin-kapt")
    alias(libs.plugins.kotlin.compose)

}
hilt {
    enableAggregatingTask = false
}

android {
    namespace = "com.compose.concept"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.compose.concept"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // Enable code shrinking and resource shrinking for release builds
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false // Typically disable for debug builds
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        // Enable Jetpack Compose
        compose = true
        dataBinding = true
    }

}

dependencies {

    // Core & UI
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat) // Keep if using AppCompat themes/widgets anywhere
    implementation(libs.google.material) // Material 2 components
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx) // Useful even with Compose for underlying structure
    implementation(libs.androidx.constraintlayout) // Keep if using XML layouts

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx) // For Fragment-based navigation
    implementation(libs.androidx.navigation.ui.ktx) // UI elements for Fragment navigation
    implementation(libs.androidx.navigation.compose) // For Compose navigation

    // ViewModel & LiveData & Lifecycle Scope for Compose
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx) // For lifecycleScope
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose) // For collectAsStateWithLifecycle

    // Room (Database)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx) // Coroutines support
    ksp(libs.androidx.room.compiler) // Use KSP for Room annotation processing

    // Retrofit (Networking)
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofit.converter.gson)
    implementation(libs.squareup.okhttp3.logging.interceptor) // For logging

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // WorkManager
    implementation(libs.androidx.work.runtime.ktx)

    // Hilt (Dependency Injection)
    implementation(libs.google.hilt.android)
    ksp(libs.google.hilt.compiler) // Use KSP for Hilt annotation processing
    // Hilt WorkManager Integration
    implementation(libs.androidx.hilt.work)
    ksp(libs.androidx.hilt.compiler) // Use KSP for Hilt extension annotation processing
    // Hilt Navigation Compose Integration
    implementation(libs.androidx.hilt.navigation.compose)

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom)) // Import BOM
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3) // Material 3 components
    // implementation(libs.androidx.compose.material) // Include if using M2 components
    implementation(libs.androidx.activity.compose) // Integration with Activity

    // Testing
    testImplementation(libs.test.junit)
    testImplementation(libs.test.coroutines) // Coroutines testing utilities
    testImplementation(libs.test.mockito.core) // Mockito core
    testImplementation(libs.test.mockito.kotlin) // Mockito Kotlin helpers
    testImplementation(libs.test.arch.core) // For LiveData testing (InstantTaskExecutorRule)
    testImplementation(libs.test.room) // Room testing utilities

    // Android Testing (androidTest)
    androidTestImplementation(libs.test.androidx.junit)
    androidTestImplementation(libs.test.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM for Compose testing
    androidTestImplementation(libs.test.compose.ui.junit4) // Compose testing rules
    androidTestImplementation(libs.test.hilt.android) // Hilt testing utilities
    kspAndroidTest(libs.test.hilt.compiler) // Use KSP for Hilt test annotation processing

    // Debug Implementation (only included in debug builds)
    debugImplementation(libs.debug.compose.ui.tooling) // Compose UI tooling (Layout Inspector)
    debugImplementation(libs.debug.compose.ui.test.manifest) // Compose test manifest
}