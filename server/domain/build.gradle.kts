import me.aricheton.gradle.plugin.Dependencies

plugins {
    `java-library`
    id("template.kotlin.project")
}

dependencies {
    api(Dependencies.Arrow.core)
}
