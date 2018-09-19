package dto.musix

import com.google.gson.annotations.SerializedName

data class MusicGenre(@SerializedName("music_genre_id")
                      val musicGenreId: Int = 0,
                      @SerializedName("music_genre_vanity")
                      val musicGenreVanity: String = "",
                      @SerializedName("music_genre_parent_id")
                      val musicGenreParentId: Int = 0,
                      @SerializedName("music_genre_name_extended")
                      val musicGenreNameExtended: String = "",
                      @SerializedName("music_genre_name")
                      val musicGenreName: String = "")