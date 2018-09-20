package com.telegram.horuktaras.olx.actions

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import com.telegram.horuktaras.olx.utils.Config
import dto.discogs.DiscogsSearchResponse
import dto.discogs.Result
import java.util.regex.Pattern

class DiscogsAPI {

    private var SEARCH_API = "/database/search?&key={key}&secret={secret}"

    fun getInfoPerArtistAndTitleFields(artist: String, title: String, maxResultsNumber: Int): List<Result?>? {
        val eArtist = getOnlyStrings(artist)
        val eTitle = getOnlyStrings(title)

        val asJson = Unirest.get("${Config().loadMainProperty("disogs.url")}$SEARCH_API")
                .queryString("per_page", maxResultsNumber.toString())
                .queryString("artist", eArtist)
                .queryString("track", eTitle)
                .routeParam("key", Config().loadMainProperty("discogs.key"))
                .routeParam("secret", Config().loadMainProperty("discogs.secret"))
                .asString()

        val fromJson = Gson().fromJson(asJson.body.toString(), DiscogsSearchResponse::class.java)
        return fromJson.results
    }

    private fun getOnlyStrings(s: String): String {
        val pattern = Pattern.compile("[^a-z A-Z]")
        val matcher = pattern.matcher(s)
        return matcher.replaceAll("")
                .replace(" ", "+")
                .replace("++", "+")
                .toLowerCase()
    }
}


fun main(args: Array<String>) {
    val info = DiscogsAPI().getInfoPerArtistAndTitleFields("Dimitri Vegas & Like Mike, Bassjackers", "The Jungle", 5)
    println(info.toString()
    )

}