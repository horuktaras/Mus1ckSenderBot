package util

import java.util.*

open class Config {
    private val propertiesPath = "main.properties"

    fun loadMainProperty(property: String): String {
        return load(property)
    }

    private fun load(property: String): String {

        val properties = Properties()
        val currentThread = Thread.currentThread()
        val contextClassLoader = currentThread.contextClassLoader
        val propertiesStream = contextClassLoader.getResourceAsStream(propertiesPath)
        if (propertiesStream != null) {
            properties.load(propertiesStream)
            propertiesStream.close()
        } else {
            println("Error in loading configuration propertyFileName from $propertiesPath")
        }
        return properties.getProperty(property).toString()
    }
}