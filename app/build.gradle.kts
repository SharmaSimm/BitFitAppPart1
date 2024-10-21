plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt") // Apply the KAPT plugin
}

android {
    namespace = "com.example.bitfitapppart1"
    compileSdk = 33 // or your target SDK version

    defaultConfig {
        applicationId = "com.example.bitfitapp" // Change to your app's package name
        minSdk = 21 // or your minimum SDK version
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0") // Adjust as necessary
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0") // Example dependency for KAPT
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.code.gson:gson:2.10.1")
    // Add your other dependencies here
}
