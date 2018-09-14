package com.telegram.horuktaras.olx.dto

import com.google.gson.annotations.SerializedName

data class Song(
        @SerializedName("duration") val duration: Integer,
        @SerializedName("mp3") val mp3: String,
        @SerializedName("artist") val artist: String,
        @SerializedName("artist_url") val artist_url: String,
        @SerializedName("id") val id: Integer,
        @SerializedName("title") val title: String,
        @SerializedName("url") val url: String
)
