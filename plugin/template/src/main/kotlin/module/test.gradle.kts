package module

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

/**
 *  Split Unit and Integration testing within 2 separated tasks.
 *  Task dependency should be:
 *  ---> test (run UT) ---> UT (task alias, do nothing) ---> IT (run IT) ---> check -->
 *
 *  Directory:
 *  - UT/IT: src/test/kotlin
 *  Regex:
 *  - UT: *UT*, *Test*
 *  - IT: *IT*
 **/
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
                        systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
                        systemProperty("junit.jupiter.execution.parallel.enabled", "true")
                        systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
                        systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "same_thread")
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
                        systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
                        systemProperty("junit.jupiter.execution.parallel.enabled", "true")
                        systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
                        systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "same_thread")
                        shouldRunAfter(tasks.named("UT"))
                    }
                }
            }
        }
    }
}

// Run IT when running `check`
tasks.named("check") {
    dependsOn += testing.suites.named("IT")
}

// Create UT task alias (do nothing other than running test
task("UT") {
    group = "verification"
    description = "Run the ut suite."
    dependsOn += testing.suites.named("test")
}
