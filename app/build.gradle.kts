plugins {
    alias(libs.plugins.android.application)
    id("kotlin-parcelize")
}

val parcelizeCompilerPlugin by configurations.creating

android {
    namespace = "com.example.a113zadaniebaseadaptersamochody"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.a113zadaniebaseadaptersamochody"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    parcelizeCompilerPlugin("org.jetbrains.kotlin:kotlin-parcelize-compiler:2.1.0")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        parcelizeCompilerPlugin.files.forEach { file ->
            if (file.name.contains("parcelize")) {
                freeCompilerArgs.add("-Xplugin=${file.absolutePath}")
            }
        }
    }
}