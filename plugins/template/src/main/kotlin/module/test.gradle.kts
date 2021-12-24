package module

import gradle.kotlin.dsl.accessors._1f1a8c581782f1af75841a8c02956a22.implementation
import gradle.kotlin.dsl.accessors._1f1a8c581782f1af75841a8c02956a22.java
import gradle.kotlin.dsl.accessors._1f1a8c581782f1af75841a8c02956a22.testing
import org.gradle.kotlin.dsl.`jvm-test-suite`
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

plugins {
    `jvm-test-suite`
    kotlin("jvm")
}

object Directories {
    val test = setOf("src/test/kotlin")
}

object Regex {
    val UT = setOf("**/*UT*", "**/*Test*")
    val IT = setOf("**/*IT*")
}

@Suppress("UnstableApiUsage")
testing {
    suites {
        getByName("test", JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                implementation(project)
            }
            sources {
                java.setSrcDirs(Directories.test)
            }
            targets {
                all {
                    testTask.configure {
                        include(Regex.UT)
                        exclude(Regex.IT)
                    }
                }
            }
        }
        register("IT", JvmTestSuite::class) {
            dependencies {
                implementation(project)
            }
            sources {
                java.setSrcDirs(Directories.test)
            }
            targets {
                all {
                    testTask.configure {
                        include(Regex.IT)
                        exclude(Regex.UT)
                        shouldRunAfter(tasks.named("UT"))
                    }
                }
            }
        }
    }
}


// Task dependency : test -> UT (empty/alias) -> IT -> check
tasks.named("check") {
    dependsOn += testing.suites.named("IT")
}

task("UT") {
    group = "verification"
    description = "Run the ut suite."
    dependsOn += testing.suites.named("test")
}
