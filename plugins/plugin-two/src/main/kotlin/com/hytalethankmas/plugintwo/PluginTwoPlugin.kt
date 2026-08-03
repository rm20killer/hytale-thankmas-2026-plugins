package com.hytalethankmas.plugintwo

import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import java.util.logging.Level

class PluginTwoPlugin(init: JavaPluginInit) : JavaPlugin(init) {
    override fun setup() {
        logger.at(Level.INFO).log("PluginTwo set up")
    }

    override fun start() {
        logger.at(Level.INFO).log("PluginTwo started")
    }

    override fun shutdown() {
        logger.at(Level.INFO).log("PluginTwo shut down")
    }
}
