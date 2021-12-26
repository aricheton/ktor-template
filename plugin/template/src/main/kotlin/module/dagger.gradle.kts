package module

import me.aricheton.gradle.plugin.Dependencies

plugins {
    id("dependency")
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.kapt)
}
