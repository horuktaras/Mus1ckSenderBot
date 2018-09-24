package com.telegram.horuktaras.olx

import com.telegram.horuktaras.olx.actions.BotTrigger
import com.telegram.horuktaras.olx.utils.Config
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class GetInfoBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return Config().loadMainProperty("get.info.bot.name")
    }

    override fun onUpdateReceived(update: Update?) {
        val trigger = BotTrigger.create()
        trigger.sendInfoToChannel(update?.channelPost!!.text)
    }

    override fun getBotToken(): String {
        return Config().loadMainProperty("get.info.bot.token")
    }
}