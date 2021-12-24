package module

import gradle.kotlin.dsl.accessors._fe4786bb74149843ef3aa76a3d93e592.implementation
import gradle.kotlin.dsl.accessors._fe4786bb74149843ef3aa76a3d93e592.test
import gradle.kotlin.dsl.accessors._fe4786bb74149843ef3aa76a3d93e592.testImplementation
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
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

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    targetCompatibility = "17"
}
