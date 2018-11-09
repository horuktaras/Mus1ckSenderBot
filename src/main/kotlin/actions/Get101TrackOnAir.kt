package actions

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.mashape.unirest.http.Unirest
import dto.onehundredone.Radio101Response
import enums.Station

class Get101TrackOnAir {

    private var URL = "http://101.ru/api/channel/getTrackOnAir/{channelID}/channel/?dataFormat=json"

    fun getTrack(channelID: Int): Map<String?, String?> {
        var fromJson: Radio101Response? = null
        val request = Unirest.get(URL)
                .routeParam("channelID", channelID.toString())
        val asJson = request
                .asString()
        println("101 URL: ${request.url}")
        println("101 response status: ${asJson.status}")

        try {
            fromJson = Gson().fromJson(asJson.body, Radio101Response::class.java)
        } catch (e: Exception) {
            println("Seems field was not filled by 101. Error:\n $e})")
        }
        return mapOf(Pair(fromJson?.result?.jsonMemberShort?.title, fromJson?.result?.about?.audio?.get(0)?.filename))
    }
}

fun main(args: Array<String>) {
    println(Get101TrackOnAir().getTrack(Station.DEEP.value))
}