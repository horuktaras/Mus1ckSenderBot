package com.telegram.horuktaras.olx.actions

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import dto.discogs.DiscogsSearchResponse
import dto.discogs.Result

class DiscogsAPI(){

    fun getInfoPerArtistAndTitleFields(artist:String, title:String, maxResultsNumber:Integer): List<Result?>? {
        val query = "$artist+$title"
        val asJson = Unirest.get("https://api.discogs.com/database/search?q={query}&key={key}&secret={secret}")
                .routeParam("per_page", maxResultsNumber.toString())
                .queryString("query", query)
                .queryString("key", "aWCocpDWaKcwnKVBgSVq")
                .queryString("secret", "ZZahoqyGXGEtwAJPPvDCDnPTJGsKCAQb")
                .asJson()

        val fromJson = Gson().fromJson(asJson.body.toString(), DiscogsSearchResponse::class.java)
        return fromJson.results
    }
}