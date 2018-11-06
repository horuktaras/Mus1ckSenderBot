package actions.bots

import actions.Get101TrackOnAir
import enums.Command
import enums.Station
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import util.Config
import java.io.File
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.*


class Get101TrackBot : TelegramLongPollingBot() {

    val TMP_MUSIC_DIR = System.getProperty("user.dir") + "/tmp/"

    override fun onUpdateReceived(update: Update?) {
        val msg: Message = update?.message ?: Message()
        if (msg.text == Command.START.command) {
            chooseGenreFromButton(msg)
        }
        if (update?.hasCallbackQuery()!!) {
            findCommandFromCallBack(update.callbackQuery)
        }
    }

    override fun getBotUsername(): String {
        return Config().loadMainProperty("get.101.track.bot.name")
    }

    override fun getBotToken(): String {
        return Config().loadMainProperty("get.101.track.bot.token")
    }

    private fun chooseGenreFromButton(message: Message) {
        val sm = SendMessage()
        sm.chatId = message.chat.id.toString()
        sm.text = "Choose Radio Station:"
        sm.enableHtml(true)
        sm.enableMarkdown(true)
        sm.enableWebPagePreview()
        sm.replyMarkup = createGenresTableMarkup()
        execute(sm)
    }

    private fun createGenresTableMarkup(): InlineKeyboardMarkup? {
        val markup = InlineKeyboardMarkup()

        val btnsFirstLine = hashMapOf<String, InlineKeyboardButton>()
        val btnsSecondLine = hashMapOf<String, InlineKeyboardButton>()

        btnsFirstLine[Station.DNB.title] = InlineKeyboardButton().setText(Station.DNB.title).setCallbackData(Station.DNB.name)
        btnsFirstLine[Station.DUBSTEP.title] = InlineKeyboardButton().setText(Station.DUBSTEP.title).setCallbackData(Station.DUBSTEP.name)
        btnsFirstLine[Station.DEEP.title] = InlineKeyboardButton().setText(Station.DEEP.title).setCallbackData(Station.DEEP.name)

        btnsSecondLine[Station.TRAP.title] = InlineKeyboardButton().setText(Station.TRAP.title).setCallbackData(Station.TRAP.name)
        btnsSecondLine[Station.LIQUID.title] = InlineKeyboardButton().setText(Station.LIQUID.title).setCallbackData(Station.LIQUID.name)
        btnsSecondLine[Station.BREAKBEAT.title] = InlineKeyboardButton().setText(Station.BREAKBEAT.title).setCallbackData(Station.BREAKBEAT.name)
        val rowFirst = Collections.unmodifiableList(btnsFirstLine.values.toList())
        val rowSecond = Collections.unmodifiableList(btnsSecondLine.values.toList())
        markup.keyboard = listOf(rowFirst, rowSecond)
        return markup
    }

    private fun findCommandFromCallBack(callbackQuery: CallbackQuery) {
        for (i in 0 until Station.values().size) {
            if (callbackQuery.data.contains(Station.values()[i].name)) {
                val track = Get101TrackOnAir().getTrack(Station.values()[i].value)
                if (track.isNotEmpty()) {
                    sentAudioToChannel(callbackQuery, track)
                }
            }
        }
    }

    private fun sentAudioToChannel(callbackQuery: CallbackQuery, searchResult: Map<String?, String?>) {
        val item = searchResult.toList()[0]
        val name = item.first
        val url = item.second
        if (url !=null){
        createAndCopyNewFile(url!!, name!!)
        val audio = SendAudio()
        audio.chatId = callbackQuery.message.chat.id.toString()
        audio.disableNotification
        audio.setAudio(File("$TMP_MUSIC_DIR\\$name.mp3"))
        audio.caption = "Title: $name"
            println("Track has been sent: $name")
        execute(audio)
        Files.delete(File("$TMP_MUSIC_DIR\\$name.mp3").toPath())}
        else {
            val error = "No file in response from Radio"
            val msg = SendMessage()
            msg.chatId = callbackQuery.message.chat.id.toString()
            msg.text = error
            execute(msg)
            println(error)
        }
    }

    private fun createAndCopyNewFile(url: String, name: String) {
        val stream = URL(url).openStream()
        Files.copy(stream, Paths.get("$TMP_MUSIC_DIR\\$name.mp3"), StandardCopyOption.REPLACE_EXISTING)
        stream.close()
    }

}