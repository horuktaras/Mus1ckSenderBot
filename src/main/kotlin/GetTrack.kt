import actions.bots.GetInfoBot
import actions.bots.GetTrackBot
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botapi = TelegramBotsApi()
    botapi.registerBot(GetInfoBot())
    botapi.registerBot(GetTrackBot())
    println("GetTrack has been started...")
}
