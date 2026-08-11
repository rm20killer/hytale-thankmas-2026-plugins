plugins {
    id("gg.ginco.hygradle.workspace")
}

hytaleWorkspace {
    serverVersion = "0.6.0-pre.11"
    // serverDir defaults to ./run
    // modProjects auto-detects :plugins:plugin-one and :plugins:plugin-two
}
