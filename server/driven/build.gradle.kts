plugins{
    `java-library`
    id("dependency")
    id("template.kotlin.project")
}

dependencies {
    implementation(project(":server:domain"))
    implementation(project(":server:shared"))
}
