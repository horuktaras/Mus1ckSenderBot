package com.telegram.horuktaras.olx

import com.telegram.horuktaras.olx.actions.bots.GetTrackBot
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    botapi.registerBot(GetInfoBot())
    botapi.registerBot(GetTrackBot())
    print("GetTrack has been started...")
}
