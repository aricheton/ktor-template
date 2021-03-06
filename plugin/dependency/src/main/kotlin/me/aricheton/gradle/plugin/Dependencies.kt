package me.aricheton.gradle.plugin

object Dependencies {
    object Arrow {
        const val core = "io.arrow-kt:arrow-core:${Versions.arrow}"
    }

    object Kotlin {
        const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object KLint {
        const val gradle = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.klint}"
    }

    object Logback {
        const val classic = "ch.qos.logback:logback-classic:${Versions.logback}"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.kapt}"
        const val kapt = "com.google.dagger:dagger-compiler:${Versions.kapt}"
    }

    object Versions {
        const val arrow = "1.0.1"
        const val kotlin = "1.6.10"
        const val klint = "10.2.0"
        const val java = "17"
        const val logback = "1.2.10"
        const val kapt = "2.40.5"
    }
}
