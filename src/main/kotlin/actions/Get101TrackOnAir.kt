package com.telegram.horuktaras.olx.actions

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import dto.onehundredone.Radio101Response

class Get101TrackOnAir {

    private var URL = "http://101.ru/api/channel/getTrackOnAir/{channelID}/channel/?dataFormat=json"

    fun getTrack(channelID: Int): Map<String?, String?> {

        val asJson = Unirest.get(URL)
                .routeParam("channelID", channelID.toString())
                .asString()

        val fromJson = Gson().fromJson(asJson.body, Radio101Response::class.java)
        fromJson.result?.about?.audio?.get(0)?.filename

        return mapOf(Pair(fromJson.result?.jsonMemberShort?.title, fromJson.result?.about?.audio?.get(0)?.filename))
    }
}

fun main(args: Array<String>) {
    println(Get101TrackOnAir().getTrack(6))
}