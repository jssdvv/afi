import dev.icerock.gradle.MRVisibility
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.application)
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
    
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
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
    
    sourceSets {
        val commonMain by getting {
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
                implementation(libs.adrielcafe.voyager.transitions)
                implementation(libs.adrielcafe.voyager.navigator)
                implementation(libs.adrielcafe.voyager.koin)

                //Resources Management
                implementation(libs.icerock.moko.resources.compose)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                //AndroidX
                implementation(libs.androidx.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)

                //Coroutines
                implementation(libs.jetbrains.kotlinx.coroutines.android)

                //HTTP Client
                implementation(libs.ktor.client.okhttp)

                //Databases
                implementation(libs.cashapp.sqldelight.android.driver)
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
                //HTTP Client
                implementation(libs.ktor.client.darwin)

                //Databases
                implementation(libs.cashapp.sqldelight.native.driver)
            }
        }
        val desktopMain by getting {
            dependsOn(commonMain)
            dependencies {
                //Kotlin Multiplatform Compose
                implementation(compose.desktop.currentOs)

                //Databases
                implementation(libs.cashapp.sqldelight.sqlite.driver)
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
        getByName("release") {
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
    multiplatformResourcesClassName = "sharedRes"
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

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            packageName = "afi"
            //outputBaseDir.set(project.buildDir.resolve(""))
            targetFormats(
                TargetFormat.Deb,
                TargetFormat.Rpm,
                TargetFormat.Exe,
                TargetFormat.Msi
            )
            linux {
                packageVersion = "1.0.0"
                //iconFile.set(project.file(""))
            }
            windows {
                packageVersion = "1.0.0"
                //iconFile.set(project.file(""))
            }
        }
    }
}