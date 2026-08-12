pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    id("gg.ginco.hygradle.settings") version "0.3.1"
}

rootProject.name = "hytale-thankmas-2026-plugins"
include(":plugins:plugin-one", ":plugins:plugin-two", "plugins:hytale-x-tiltify")
