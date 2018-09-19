package com.telegram.horuktaras.olx.utils

import java.io.File
import java.io.FileInputStream
import java.util.*

open class Config {
    private val CONFIGURATION_BOT_FILE = "main.properties"

    fun loadMainProperty(property: String): String {
        return load(CONFIGURATION_BOT_FILE, property)
    }

    private fun load(propertyFileName: String, property: String): String {
        val botSettings = Properties()
        val file = File(getFileWithUtil(propertyFileName)!!.replace("%20", " "))
        if (file.exists()) {
            val input = FileInputStream(file)
            botSettings.load(input)
            input.close()
        } else {
            println("Error in loading configuration propertyFileName from ${file.path}.")
        }
        return botSettings.getProperty(property).toString()
    }

    fun generatePath(folders: Array<String>): String? {
        var path = File.separator

        for (folder: String in folders) {
            if (folder.isNotEmpty()) {
                path = path + folder + File.separator
            }
        }
        return path
    }

    private fun getFileWithUtil(fileName: String): String? {
        val cl: ClassLoader = ClassLoader.getSystemClassLoader()
        return cl.getResource(fileName).path
    }
}