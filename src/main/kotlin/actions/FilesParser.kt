package com.telegram.horuktaras.olx.actions

import com.mpatric.mp3agic.Mp3File
import com.telegram.horuktaras.olx.dto.Track
import com.telegram.horuktaras.olx.utils.Config
import java.io.File
import java.nio.file.Files
import java.util.*

open class FilesParser {

    open fun parseFilesFromFolder(path: String): HashMap<Mp3File, Track>? {

        val dir = File(path)
        val files = dir.listFiles()

        val trackSet = HashMap<Mp3File, Track>()

        for (file: File in files) {
            if (file.isFile && file.name.contains(".mp3")) {
                val mp3File = Mp3File(file.path)
                val id2 = mp3File.id3v2Tag
                when {
                    id2.artist.isNullOrEmpty() -> throw Exception("artist is empty in ${mp3File.filename}")
                    id2.title.isNullOrEmpty() -> throw Exception("title is empty in ${mp3File.filename}")
                    id2.album.isNullOrEmpty() -> throw Exception("album is empty in ${mp3File.filename}")
                    id2.year.isNullOrEmpty() -> throw Exception("year is empty in ${mp3File.filename}")
                    id2.albumImage.isEmpty() -> throw Exception("albumImage is empty in ${mp3File.filename}")
                    id2.genreDescription.isNullOrEmpty() -> throw Exception("genreDescription is empty in ${mp3File.filename}")
                }
                val imagePath = System.getProperty("user.dir") + Config().loadMainProperty("music.location.sent") + "/images/${id2.artist} - ${id2.title}.jpg"
                val track = Track(
                        id2.artist,
                        id2.title,
                        id2.album,
                        id2.year,
                        File(imagePath).toPath(),
                        id2.genreDescription,
                        file,
                        mp3File.lengthInSeconds
                )
                Files.write(File(imagePath).toPath(), id2.albumImage)
                trackSet.putIfAbsent(mp3File, track)
            }
        }
        return trackSet
    }
}





