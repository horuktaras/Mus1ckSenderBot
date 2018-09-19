package com.telegram.horuktaras.olx

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi

val chatID: String = ""

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    botapi.registerBot(GetInfoBot())
    print("PublishBot has been started...")
}
