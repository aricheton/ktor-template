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

tasks.named("check") {
    dependsOn += testing.suites.named("IT")
}

task("UT") {
    group = "verification"
    description = "Run the ut suite."
    dependsOn += testing.suites.named("test")
}
