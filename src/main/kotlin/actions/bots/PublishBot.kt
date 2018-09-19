package com.telegram.horuktaras.olx

import com.telegram.horuktaras.olx.utils.Config
import org.telegram.telegrambots.api.objects.Message
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot

class PublishBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return Config().loadMainProperty("mus1c.bot.name")
    }

    override fun onUpdateReceived(update: Update?) {
        val message: Message = update?.message ?: Message()
    }

    override fun getBotToken(): String {
        return Config().loadMainProperty("mus1c.bot.token")
    }


}