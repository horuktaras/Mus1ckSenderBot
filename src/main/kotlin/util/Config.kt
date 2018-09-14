package com.telegram.horuktaras.olx.utils

import com.mashape.unirest.http.Unirest
import org.apache.http.conn.scheme.PlainSocketFactory
import org.apache.http.conn.scheme.Scheme
import org.apache.http.conn.scheme.SchemeRegistry
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.conn.SingleClientConnManager
import util.MockSSLSocketFactory
import java.io.File
import java.io.FileInputStream
import java.security.KeyManagementException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.UnrecoverableKeyException
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

    private fun makeClient(): DefaultHttpClient {
        val schemeRegistry = SchemeRegistry()
        schemeRegistry.register(Scheme("http", 80, PlainSocketFactory.getSocketFactory()))
        try {
            schemeRegistry.register(Scheme("https", 443, MockSSLSocketFactory()))
        } catch (e: KeyManagementException) {
            e.printStackTrace()
        } catch (e: UnrecoverableKeyException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        }

        val cm = SingleClientConnManager(schemeRegistry)
        return DefaultHttpClient(cm)
    }

    /**
     * Set HTTP Client to Unirest
     */
    fun certificateTrusting() {
        Unirest.setHttpClient(makeClient())
    }

    fun setWebHook(){
        Unirest.get("https://api.telegram.org/bot"
                + Config().loadMainProperty("bot.token")
                + "/setWebhook?url=https://www.example.com/"
                + Config().loadMainProperty("bot.name"))
    }
}