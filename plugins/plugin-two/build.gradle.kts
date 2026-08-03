plugins {
    id("gg.ginco.hygradle")
    kotlin("jvm") version "2.3.21"
}

version = "1.0.0"

hytale {
    group = "HytaleThankmas"
    name = "PluginTwo"
    description = "PluginTwo for Thankmas 2026"
    mainClass = "com.hytalethankmas.plugintwo.PluginTwoPlugin"
    author("Hytale Thankmas Team")

    bundleDependencies = true
    // serverVersion inherited from hytaleWorkspace
}
