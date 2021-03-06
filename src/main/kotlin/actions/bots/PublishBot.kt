package actions.bots

import util.Config
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

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