package module

import me.aricheton.gradle.plugin.Dependencies
import java.nio.file.Files
import java.nio.file.StandardCopyOption

plugins {
    kotlin("jvm")
    java
}

// Inspired by: https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSetOutput.html
val generatedResourceDir = "$buildDir/generated-resources/main"
val logbackFilename = "logback.xml"
val module: Module = javaClass.module

sourceSets {
    kotlin {
        main {
            output.dir(dir = generatedResourceDir, "builtBy" to "generateLogbackConfig")
        }
    }
}

task("generateLogbackConfig") {
    description = "Generate default logback config"
    group = "other"
    outputs.dir(generatedResourceDir)
    doLast {
        val generated = File(generatedResourceDir, logbackFilename)
        module.getResourceAsStream(logbackFilename).use { input ->
            requireNotNull(input) { "Unable to retrieve logback config '$logbackFilename'" }
            Files.copy(input, generated.toPath(), StandardCopyOption.REPLACE_EXISTING)
        }
    }
}

dependencies {
    implementation(Dependencies.Logback.classic)
}

apply(plugin= "idea")
