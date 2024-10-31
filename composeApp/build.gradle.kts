plugins {
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.cashapp.sqldelight)
    id("com.google.gms.google-services")
    alias(libs.plugins.composeCompiler)
}

group = "com.jssdvv.afi"
version = "1.0"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
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
                // Kotlin Multiplatform Compose
                implementation(compose.components.resources)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.animation)
                implementation(compose.runtime)
                implementation(compose.ui)

                // Coroutines
                implementation(libs.jetbrains.kotlinx.coroutines.core)

                // Dependencies Injection
                implementation(project.dependencies.platform(libs.insert.koin.bom))
                implementation(libs.insert.koin.compose)
                implementation(libs.insert.koin.core)

                // SQLDelight Extensions
                implementation(libs.cashapp.sqldelight.coroutines.extensions)

                // HTTP Client
                implementation(libs.ktor.client.core)

                // HTML Parser
                implementation(libs.mohamedrejeb.ksoup.html)

                // Serialization
                implementation(libs.jetbrains.kotlinx.serialization.json)

                // Navigation
                implementation(libs.jetbrains.androidx.navigation.compose)
                implementation(libs.jetbrains.androidx.lifecycle.viewmodel.compose)

                // Permissions
                implementation(libs.bundles.icerock.moko.permissions)

                implementation(platform("com.google.firebase:firebase-bom:33.5.1"))

                implementation("dev.gitlive:firebase-firestore:2.1.0")
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                // AndroidX
                implementation(libs.androidx.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)

                // Constraint Layout Compose
                implementation(libs.androidx.constraintlayout.compose)

                // Compose
                implementation(project.dependencies.platform(libs.androidx.compose.bom))
                implementation(libs.bundles.androidx.compose)

                // Dependencies Injection
                implementation(project.dependencies.platform(libs.insert.koin.bom))
                implementation(libs.insert.koin.android)
                implementation(libs.insert.koin.core)

                // HTTP Client
                implementation(libs.ktor.client.okhttp)

                // Databases
                implementation(libs.cashapp.sqldelight.android.driver)

                // CameraX
                implementation(libs.bundles.androidx.camera)

                // MLKitVision
                implementation(libs.bundles.google.mlkit)

                implementation("com.google.firebase:firebase-firestore-ktx")
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
                // HTTP Client
                implementation(libs.ktor.client.darwin)

                // Databases
                implementation(libs.cashapp.sqldelight.native.driver)
            }
        }
    }
}

android {
    namespace = "com.jssdvv.afi"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/composeResources")

    defaultConfig {
        applicationId = "com.jssdvv.afi"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
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
        create("DirectoryDatabase") {
            packageName.set("com.jssdvv.afi")
        }
    }
}