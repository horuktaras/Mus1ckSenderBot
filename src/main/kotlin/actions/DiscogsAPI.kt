package com.telegram.horuktaras.olx.actions

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import com.telegram.horuktaras.olx.utils.Config
import dto.discogs.DiscogsSearchResponse
import dto.discogs.Result

class DiscogsAPI() {

    private var SEARCH_API = "/database/search?q={query}&key={key}&secret={secret}"

    fun getInfoPerArtistAndTitleFields(artist: String, title: String, maxResultsNumber: Int): List<Result?>? {
        val query = "${artist.replace(" ", "+")}+${title.replace(" ", "+")}"
        val asJson = Unirest.get("${Config().loadMainProperty("disogs.url")}$SEARCH_API")
                .queryString("per_page", maxResultsNumber.toString())
                .routeParam("query", query)
                .routeParam("key", Config().loadMainProperty("discogs.key"))
                .routeParam("secret", Config().loadMainProperty("discogs.secret"))
                .asJson()

        val fromJson = Gson().fromJson(asJson.body.toString(), DiscogsSearchResponse::class.java)
        return fromJson.results
    }
}