package com.telegram.horuktaras.olx

import com.mashape.unirest.http.Unirest
import com.telegram.horuktaras.olx.actions.Parser
import com.telegram.horuktaras.olx.enums.Tag
import com.telegram.horuktaras.olx.utils.Config
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi


fun main(args: Array<String>) {
    setup()
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    botapi.registerBot(Bot())
    print("Bot has been started...")

    release(isProd = false)
}

fun release(isProd: Boolean) {
    val location = System.getProperty("user.dir") + Config().loadMainProperty("music.location.new")

    val hard = Parser().parseFilesFromFolder(location + Tag.HARD.value)
    val middle = Parser().parseFilesFromFolder(location + Tag.MIDDLE.value)
    val light = Parser().parseFilesFromFolder(location + Tag.LIGHT.value)
    BotAction().sendTrackToChannel(isProd, hard!!, Tag.HARD.value)
    BotAction().sendTrackToChannel(isProd, middle!!, Tag.MIDDLE.value)
    BotAction().sendTrackToChannel(isProd, light!!, Tag.LIGHT.value)
}

private fun setup(){
    Config().certificateTrusting()
    Config().setWebHook()
}
