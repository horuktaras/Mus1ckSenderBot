package com.telegram.horuktaras.olx.dto

import java.io.File
import java.nio.file.Path

data class Track(
        val artist: String,
        val title: String,
        val album: String,
        val year: String,
        val art: Path?,
        val genre: String,
        val file: File,
        val duration: Long
)
