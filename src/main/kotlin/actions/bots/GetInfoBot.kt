package actions.bots

import actions.BotTrigger
import util.Config
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class GetInfoBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return Config().loadMainProperty("get.info.bot.name")
    }

    override fun onUpdateReceived(update: Update?) {
        val trigger = BotTrigger.create()
        val income = update?.channelPost!!.text
        println("Message from BOT channel has come: $income")
        trigger.sendInfoToChannel(income)
    }

    override fun getBotToken(): String {
        return Config().loadMainProperty("get.info.bot.token")
    }
}