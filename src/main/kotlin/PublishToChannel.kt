import actions.FilesParser
import actions.PublisherMus1ck
import actions.bots.PublishBot
import enums.Tag
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi
import util.Config

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    botapi.registerBot(PublishBot())
    print("PublishBot has been started...")
    release(isProd = false)
}

fun release(isProd: Boolean) {
    val location = System.getProperty("user.dir") + Config().loadMainProperty("music.location.new")

    val hard = FilesParser().parseFilesFromFolder(location + Tag.HARD.value)
    val middle = FilesParser().parseFilesFromFolder(location + Tag.MIDDLE.value)
    val light = FilesParser().parseFilesFromFolder(location + Tag.LIGHT.value)
    PublisherMus1ck().sendTrackToChannel(isProd, hard!!, Tag.HARD.value)
    PublisherMus1ck().sendTrackToChannel(isProd, middle!!, Tag.MIDDLE.value)
    PublisherMus1ck().sendTrackToChannel(isProd, light!!, Tag.LIGHT.value)
}
