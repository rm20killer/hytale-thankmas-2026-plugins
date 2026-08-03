package com.hytalethankmas.pluginone

import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import java.util.logging.Level

class PluginOnePlugin(init: JavaPluginInit) : JavaPlugin(init) {
    override fun setup() {
        logger.at(Level.INFO).log("PluginOne set up")
    }

    override fun start() {
        logger.at(Level.INFO).log("PluginOne started")
    }

    override fun shutdown() {
        logger.at(Level.INFO).log("PluginOne shut down")
    }
}
