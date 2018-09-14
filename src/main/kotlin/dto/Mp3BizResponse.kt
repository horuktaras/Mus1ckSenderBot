package com.telegram.horuktaras.olx.dto

import com.google.gson.annotations.SerializedName

data class Mp3BizResponse(
        @SerializedName("songs") val songs: List<Song>)