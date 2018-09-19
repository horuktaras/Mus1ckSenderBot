package com.telegram.horuktaras.olx

import com.telegram.horuktaras.olx.actions.Parser
import com.telegram.horuktaras.olx.enums.Tag
import com.telegram.horuktaras.olx.utils.Config
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi


fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    botapi.registerBot(PublishBot())
    print("PublishBot has been started...")
    release(isProd = false)
}

fun release(isProd: Boolean) {
    val location = System.getProperty("user.dir") + Config().loadMainProperty("music.location.new")

    val hard = Parser().parseFilesFromFolder(location + Tag.HARD.value)
    val middle = Parser().parseFilesFromFolder(location + Tag.MIDDLE.value)
    val light = Parser().parseFilesFromFolder(location + Tag.LIGHT.value)
    PublisherMus1ck().sendTrackToChannel(isProd, hard!!, Tag.HARD.value)
    PublisherMus1ck().sendTrackToChannel(isProd, middle!!, Tag.MIDDLE.value)
    PublisherMus1ck().sendTrackToChannel(isProd, light!!, Tag.LIGHT.value)
}
