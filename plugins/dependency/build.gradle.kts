import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "me.aricheton.gradle.plugin"
version = "1.0.0"

repositories {
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("dependency") {
            id = "dependency"
            description = "Cross module project dependency references"
            implementationClass = "me.aricheton.gradle.plugin.DependencyPlugin"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    targetCompatibility = "17"
}
