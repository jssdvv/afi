import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.compose.compiler)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.cashapp.sqldelight)
}

group = "com.jssdvv.afi"
version = "1.0"

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    task("testClasses")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    cocoapods {
        summary = "AFI"
        homepage = "https://github.com/jssdvv/afi"
        ios.deploymentTarget = "13.5"
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                implementation(compose.components.resources)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.animation)
                implementation(compose.runtime)
                implementation(compose.ui)

                // Kotlin
                implementation(libs.jetbrains.kotlinx.coroutines.core)
                implementation(libs.jetbrains.kotlinx.serialization.json)

                // Navigation
                implementation(libs.jetbrains.androidx.navigation.compose)
                implementation(libs.jetbrains.androidx.lifecycle.viewmodel.compose)

                // HTTP Requests
                implementation(libs.ktor.client.core)
                implementation(libs.mohamedrejeb.ksoup.html)

                // Dependency Injection
                implementation(project.dependencies.platform(libs.insert.koin.bom))
                implementation(libs.insert.koin.compose)
                implementation(libs.insert.koin.core)

                // Persisting Data
                implementation(libs.russhwolf.multiplatform.settings.no.arg)

                // Local Database
                implementation(libs.cashapp.sqldelight.coroutines.extensions)

                // External Database
                implementation(project.dependencies.platform(libs.jan.tennert.supabase.bom))
                implementation(libs.bundles.jan.tennert.supabase)

                // Permissions
                implementation(libs.bundles.icerock.moko.permissions)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                // Compose
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.constraint.layout.compose)
                implementation(project.dependencies.platform(libs.androidx.compose.bom))
                implementation(libs.bundles.androidx.compose)

                // Camera
                implementation(libs.bundles.androidx.camera)

                // HTTP Requests
                implementation(libs.ktor.client.okhttp)

                // Dependency Injection
                implementation(project.dependencies.platform(libs.insert.koin.bom))
                implementation(libs.insert.koin.android)
                implementation(libs.insert.koin.core)

                // Local Database
                implementation(libs.cashapp.sqldelight.android.driver)

                // Google ML Kit
                implementation(libs.bundles.google.mlkit)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                // HTTP Requests
                implementation(libs.ktor.client.darwin)

                // Local Database
                implementation(libs.cashapp.sqldelight.native.driver)
            }
        }
    }
}

android {
    namespace = "com.jssdvv.afi"
    compileSdk = libs.versions.android.sdk.compile.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/composeResources")

    defaultConfig {
        applicationId = "com.jssdvv.afi"
        minSdk = libs.versions.android.sdk.min.get().toInt()
        targetSdk = libs.versions.android.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.androidx.compose.ui.tooling)
    }
}

sqldelight {
    databases {
        create("database") {
            packageName.set("com.jssdvv.afi")
        }
    }
}