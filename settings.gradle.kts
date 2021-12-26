rootProject.name = "ktor-template"

includeBuild("plugin/dependency")
includeBuild("plugin/template")
include("server:app", "server:domain", "server:driven", "server:driving", "server:shared")
