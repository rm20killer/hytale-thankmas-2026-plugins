plugins {
    id("gg.ginco.hygradle.workspace")
}

hytaleWorkspace {
    serverVersion = "0.6.8"
    // serverDir defaults to ./run
    // modProjects auto-detects :plugins:plugin-one and :plugins:plugin-two
}

tasks.named("runAllMods") {
    val jars = property("pluginJars") as ConfigurableFileCollection
    jars.from(fileTree("libs") {
        include("*.jar")
    })
}