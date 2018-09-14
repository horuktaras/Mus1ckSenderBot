package com.telegram.horuktaras.olx.actions

import com.mashape.unirest.http.Unirest

class Mp3Biz {

    fun searchTrack(name: String) {
        val url = "https://mp3co.biz/s/"
        val json = Unirest.get(url + name.toLowerCase()
                .replace("-", "")
                .replace(" ", "+"))
                .asJson()

    }
}