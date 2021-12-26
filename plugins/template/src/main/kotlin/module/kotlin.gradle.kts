package module

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("dependency")
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("bom"))
    testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    targetCompatibility = "17"
}
