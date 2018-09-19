package com.telegram.horuktaras.olx.actions

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import com.telegram.horuktaras.olx.utils.Config
import dto.musix.MusiXResponse
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.methods.send.SendPhoto
import org.telegram.telegrambots.bots.DefaultAbsSender
import org.telegram.telegrambots.bots.DefaultBotOptions

open class BotTrigger() : DefaultAbsSender(DefaultBotOptions()) {
    override fun getBotToken(): String {
        return Config().loadMainProperty("get.info.bot.token")
    }


    companion object Factory {
        private var instance: BotTrigger? = null
        fun create(): BotTrigger {
            if (instance == null) {
                instance = BotTrigger()
            }
            return instance as BotTrigger
        }
    }

    fun sendInfoToChannel(income: String) {
        val chatId = "-1001225252656"
        val asJson = Unirest.get("https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.search")
                .header("X-Mashape-Key", "GNEoXWWnLQmshLVRU8anKSwt3yxap1eJU6wjsnVZsHFnqCpsOq")
                .header("X-Mashape-Host", "musixmatchcom-musixmatch.p.mashape.com")
                .queryString("q_track_artist", income.replace(" ", "+"))
                .queryString("s_track_rating", "desc")
                .queryString("page_size", 3)
                .asString()
        val tracks = Gson().fromJson(asJson.body, Array<MusiXResponse>::class.java).toList()
        (0 until tracks.size)
                .forEach {
                    val art = SendPhoto()
                    val msg = SendMessage()
                    art.chatId = chatId
                    msg.chatId = chatId
                    if (!tracks.elementAt(it).trackMbid.isEmpty()) {
                        art.photo = tracks.elementAt(it).albumCoverart500
                        art.caption = "Artist: ${tracks.elementAt(it).artistName}\n" +
                                "Title:  ${tracks.elementAt(it).trackName}\n" +
                                "Album:  ${tracks.elementAt(it).albumName}\n" +
                                "Year:  ${tracks.elementAt(it).firstReleaseDate}\n"

                        sendPhoto(art)
                    } else {
                        msg.text = "Artist: ${tracks.elementAt(it).artistName}\n" +
                                "Title:  ${tracks.elementAt(it).trackName}\n" +
                                "Album:  ${tracks.elementAt(it).albumName}\n" +
                                "Year:  ${tracks.elementAt(it).firstReleaseDate}\n"
                        execute(msg)
                    }
                }

    }


    fun getImageURLByIMBD(mbid: String) {
        Unirest.get("http://coverartarchive.org/release/$mbid")
                .header("Host", "coverartarchive.org")
                .header("Accept", "application/json")
                .asString()

    }

}

fun main(args: Array<String>) {
    BotTrigger().getImageURLByIMBD("7af1eb22-2e67-4890-ab47-8d691623d789")
}
