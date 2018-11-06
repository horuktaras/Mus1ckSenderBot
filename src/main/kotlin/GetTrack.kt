import actions.bots.GetInfoBot
import actions.bots.Get101TrackBot
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    //TODO temporary disabled. Should be reworked
    //botapi.registerBot(GetInfoBot())
    botapi.registerBot(Get101TrackBot())
    println("GetTrack has been started...")
}
