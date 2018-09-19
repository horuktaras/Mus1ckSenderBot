package dto.musix

import com.google.gson.annotations.SerializedName

data class MusiXResponse(@SerializedName("updated_time")
                         val updatedTime: String = "",
                         @SerializedName("track_share_url")
                         val trackShareUrl: String = "",
                         @SerializedName("album_coverart_100x100")
                         val albumCoverart100: String = "",
                         @SerializedName("artist_name")
                         val artistName: String = "",
                         @SerializedName("album_coverart_800x800")
                         val albumCoverart800: String = "",
                         @SerializedName("track_xboxmusic_id")
                         val trackXboxmusicId: String = "",
                         @SerializedName("track_isrc")
                         val trackIsrc: String = "",
                         @SerializedName("album_coverart_500x500")
                         val albumCoverart500: String = "",
                         @SerializedName("num_favourite")
                         val numFavourite: Int = 0,
                         @SerializedName("track_rating")
                         val trackRating: Int = 0,
                         @SerializedName("album_name")
                         val albumName: String = "",
                         @SerializedName("first_release_date")
                         val firstReleaseDate: String = "",
                         @SerializedName("album_coverart_350x350")
                         val albumCoverart350: String = "",
                         @SerializedName("has_lyrics_crowd")
                         val hasLyricsCrowd: Int = 0,
                         @SerializedName("track_edit_url")
                         val trackEditUrl: String = "",
                         @SerializedName("track_name")
                         val trackName: String = "",
                         @SerializedName("primary_genres")
                         val primaryGenres: PrimaryGenres,
                         @SerializedName("track_soundcloud_id")
                         val trackSoundcloudId: String = "",
                         @SerializedName("track_length")
                         val trackLength: Int = 0,
                         @SerializedName("commontrack_id")
                         val commontrackId: Int = 0,
                         @SerializedName("subtitle_id")
                         val subtitleId: Int = 0,
                         @SerializedName("artist_id")
                         val artistId: Int = 0,
                         @SerializedName("artist_mbid")
                         val artistMbid: String = "",
                         @SerializedName("lyrics_id")
                         val lyricsId: Int = 0,
                         @SerializedName("explicit")
                         val explicit: Int = 0,
                         @SerializedName("commontrack_vanity_id")
                         val commontrackVanityId: String = "",
                         @SerializedName("track_spotify_id")
                         val trackSpotifyId: String = "",
                         @SerializedName("secondary_genres")
                         val secondaryGenres: SecondaryGenres,
                         @SerializedName("has_richsync")
                         val hasRichsync: Int = 0,
                         @SerializedName("track_id")
                         val trackId: Int = 0,
                         @SerializedName("instrumental")
                         val instrumental: Boolean = false,
                         @SerializedName("restricted")
                         val restricted: Boolean = false,
                         @SerializedName("has_subtitles")
                         val hasSubtitles: Boolean = false,
                         @SerializedName("album_id")
                         val albumId: Int = 0,
                         @SerializedName("track_mbid")
                         val trackMbid: String = "",
                         @SerializedName("has_lyrics")
                         val hasLyrics: Boolean = false)