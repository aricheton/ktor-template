plugins {
    id("dependency")
    id("template.kotlin.project")
    application
}

dependencies {
    implementation(project(":server:driven"))
    implementation(project(":server:driving"))
    implementation(project(":server:shared"))
}

//application {
//    mainClass.set("MainKt")
//}
