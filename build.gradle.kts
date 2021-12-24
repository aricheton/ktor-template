plugins {
    id("module.ktlint")
}

allprojects {
    group = "me.aricheton.server"
    version = "1.0.0-SNAPSHOT"
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
