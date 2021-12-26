import me.aricheton.gradle.plugin.Dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("dependency")
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Kotlin.gradle)
    implementation(Dependencies.KLint.gradle)
    implementation("me.aricheton.gradle.plugin:dependency:1.0.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = Dependencies.Versions.java
    targetCompatibility = Dependencies.Versions.java
}
