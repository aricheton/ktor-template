package me.aricheton.gradle.plugin

import org.gradle.api.tasks.Nested

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

    object Versions {
        const val arrow = "1.0.1"
        const val kotlin = "1.6.10"
        const val klint = "10.2.0"
        const val java = "17"
    }
}
