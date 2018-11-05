package actions

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import util.Config
import dto.musix.MusiXResponse
import org.telegram.telegrambots.bots.DefaultAbsSender
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.InputFile

open class BotTrigger : DefaultAbsSender(DefaultBotOptions()) {

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
        sendMessageFromMusiX(income, chatId)
    }

    private fun sendMessageFromMusiX(income: String, chatId: String) {
        val musixURL = "https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.search"
        val musiXQuery = income.replace(" ", "+")
        val request = Unirest.get(musixURL)
                .header("X-Mashape-Key", "GNEoXWWnLQmshLVRU8anKSwt3yxap1eJU6wjsnVZsHFnqCpsOq")
                .header("X-Mashape-Host", "musixmatchcom-musixmatch.p.mashape.com")
                .queryString("q_track_artist", musiXQuery)
                .queryString("s_track_rating", "desc")
                .queryString("page_size", 3)
        val asJsonMusiX = request
                .asString()
        println("MusiX URL: ${request.url}.")
        println("MusiX response status: ${asJsonMusiX.status}.")
        val tracksMusiX = Gson().fromJson(asJsonMusiX.body, Array<MusiXResponse>::class.java).toList()
        (0 until tracksMusiX.size)
                .forEach {
                    val art = SendPhoto()
                    val msg = SendMessage()
                    art.chatId = chatId
                    msg.chatId = chatId
                    val elementAt = tracksMusiX.elementAt(it)
                    if (elementAt.albumCoverart500.isNotEmpty()) {
                        art.photo = InputFile(getImageURLByIMBD(elementAt.trackMbid))
                        art.caption = "Artist: ${elementAt.artistName}\n" +
                                "Title:  ${elementAt.trackName}\n" +
                                "Album:  ${elementAt.albumName}\n" +
                                "Year:  ${elementAt.firstReleaseDate.subSequence(0, 4)}\n"

                        execute(art)
                    } else {
                        msg.text = "Artist: ${elementAt.artistName}\n" +
                                "Title:  ${elementAt.trackName}\n" +
                                "Album:  ${elementAt.albumName}\n" +
                                "Year:  ${elementAt.firstReleaseDate.subSequence(0, 4)}\n"
                        execute(msg)
                    }
                }
    }

    fun getImageURLByIMBD(mbid: String): String? {
        return Unirest.get("http://coverartarchive.org/release/$mbid")
                .header("Host", "coverartarchive.org")
                .header("Accept", "application/json")
                .asString().body
    }
}
