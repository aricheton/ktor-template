rootProject.name = "ktor-template"

includeBuild("plugins/dependency")
includeBuild("plugins/template")
include("server:app", "server:domain", "server:driven", "server:driving", "server:shared")
