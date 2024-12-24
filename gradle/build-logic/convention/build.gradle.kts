import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "xyz.ksharma.composemultiplatform.gradle"

val javaVersion = libs.versions.java.get().toInt()

java {
    sourceCompatibility = JavaVersion.values()[javaVersion - 1]
    targetCompatibility = JavaVersion.values()[javaVersion - 1]
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

kotlin {
    jvmToolchain(javaVersion)
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.composeCompiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        /**
         * Supports building UIs for Android, Desktop, and Web using Jetpack Compose.
         */
        register("composeMultiplatform") {
            id = "my.compose.multiplatform"
            implementationClass = "xyz.ksharma.composemultiplatform.gradle.ComposeMultiplatformConventionPlugin"
        }

        /**
         * Configures the project for Android application development.
         */
        register("androidApplication") {
            id = "my.android.application"
            implementationClass = "xyz.ksharma.composemultiplatform.gradle.AndroidApplicationConventionPlugin"
        }

        /**
         * Configures the project for developing Android libraries.
         */
        register("androidLibrary") {
            id = "my.android.library"
            implementationClass = "xyz.ksharma.composemultiplatform.gradle.AndroidLibraryConventionPlugin"
        }

        /**
         * Adds support for Kotlin in Android projects.
         */
        register("kotlinAndroid") {
            id = "my.kotlin.android"
            implementationClass = "xyz.ksharma.composemultiplatform.gradle.KotlinAndroidConventionPlugin"
        }

        /**
         * Configures the project for Kotlin Multiplatform development, supporting JVM, Android, iOS,
         * and JS targets.
         */
        register("kotlinMultiplatform") {
            id = "my.kotlin.multiplatform"
            implementationClass = "xyz.ksharma.composemultiplatform.gradle.KotlinMultiplatformConventionPlugin"
        }
    }
}
