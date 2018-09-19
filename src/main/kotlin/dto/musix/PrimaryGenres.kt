package dto.musix

import com.google.gson.annotations.SerializedName

data class PrimaryGenres(@SerializedName("music_genre")
                         val musicGenre: List<MusicGenre>?)