import dev.icerock.gradle.MRVisibility
import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.cashapp.sqldelight)
    alias(libs.plugins.icerock.mobile.multiplatform.resources)
}

group = "com.jssdvv.afi"
version = "1.0"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            export(libs.icerock.moko.resources.compose)
        }
    }

    cocoapods {
        summary = "Compose Multiplatform App"
        homepage = "https://github.com/jssdvv/AFI"

        ios.deploymentTarget = "13.5"
    }

    sourceSets {
        commonMain {
            dependencies {
                //Kotlin Multiplatform Compose
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.animation)
                implementation(compose.runtime)
                implementation(compose.ui)

                //Coroutines
                implementation(libs.jetbrains.kotlinx.coroutines.core)

                //HTTP Client
                implementation(libs.ktor.client.core)

                //Serialization
                implementation(libs.jetbrains.kotlinx.serialization.json)

                //Navigation
                implementation(libs.adrielcafe.voyager.koin)
                implementation(libs.adrielcafe.voyager.navigator)
                implementation(libs.adrielcafe.voyager.transitions)
                implementation(libs.adrielcafe.voyager.screenmodel)

                implementation(libs.arkivanov.decompose)
                implementation(libs.arkivanov.decompose.extensions.compose.jetbrains)

                //Resources Management
                implementation(libs.icerock.moko.resources.compose)
            }
        }
        androidMain {
            dependsOn(commonMain.get())
            dependencies {
                //AndroidX
                implementation(libs.androidx.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)

                //HTTP Client
                implementation(libs.ktor.client.okhttp)

                //Databases
                implementation(libs.cashapp.sqldelight.android.driver)
            }
        }
        iosMain {
            dependsOn(commonMain.get())
            dependencies {
                //HTTP Client
                implementation(libs.ktor.client.darwin)

                //Databases
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
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

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
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compiler.get()
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.androidx.compose.ui.tooling)
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.jssdvv.afi"
    multiplatformResourcesClassName = "MR"
    multiplatformResourcesVisibility = MRVisibility.Public
    iosBaseLocalizationRegion = "en"
    multiplatformResourcesSourceSet = "commonMain"
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.jssdvv.afi")
        }
    }
}