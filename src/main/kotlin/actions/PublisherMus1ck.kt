package com.telegram.horuktaras.olx

import com.mpatric.mp3agic.Mp3File
import com.telegram.horuktaras.olx.dto.Track
import com.telegram.horuktaras.olx.utils.Config
import org.apache.commons.io.FileUtils
import org.telegram.telegrambots.api.methods.send.SendAudio
import org.telegram.telegrambots.api.methods.send.SendPhoto
import org.telegram.telegrambots.bots.DefaultAbsSender
import org.telegram.telegrambots.bots.DefaultBotOptions
import java.io.File


open class PublisherMus1ck : DefaultAbsSender(DefaultBotOptions()) {

    override fun getBotToken(): String {
        return Config().loadMainProperty("mus1c.bot.token")
    }

    internal fun sendTrackToChannel(isProd: Boolean, tracks: Map<Mp3File, Track>, type: String) {
        val id: String = if (isProd) {
            "-1001353330458"
        } else "-1001273557547"
        val files = tracks.values
        (0 until files.size)
                .forEach {
                    val msg = SendPhoto()
                    val file = SendAudio()
                    file.chatId = id
                    file.disableNotification
                    file.setNewAudio(files.elementAt(it).file)
                    file.duration = files.elementAt(it).duration.toInt()
                    file.performer = "${files.elementAt(it).artist}"
                    file.title = "${files.elementAt(it).title}"
                    msg.chatId = id
                    msg.caption = "${files.elementAt(it).artist} - ${files.elementAt(it).title}\n\n#$type #${files.elementAt(it).genre?.toLowerCase()!!
                            .replace(" ", "")
                            .replace("drum&bass", "dnb")}"
                    msg.setNewPhoto(files.elementAt(it).art?.toFile())
                    sendPhoto(msg)
                    sendAudio(file)
                    Thread.sleep(5_000)
                    when {
                        isProd -> FileUtils
                                .moveFile(
                                        files.elementAt(it).file,
                                        File(System.getProperty("user.dir") + Config().loadMainProperty("music.location.sent") + "${files.elementAt(it).artist} - ${files.elementAt(it).title}.mp3"))
                    }
                }
    }
}
