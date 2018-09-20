package dto.onehundredone

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class About(

		@field:SerializedName("text_song")
	val textSong: String? = null,

		@field:SerializedName("text_song_translate")
	val textSongTranslate: String? = null,

		@field:SerializedName("title_executor")
	val titleExecutor: String? = null,

		@field:SerializedName("isNewVideo")
	val isNewVideo: Boolean? = null,

		@field:SerializedName("video")
	val video: Video? = null,

		@field:SerializedName("title")
	val title: String? = null,

		@field:SerializedName("duration_sec")
	val durationSec: Int? = null,

		@field:SerializedName("executorsWorked")
	val executorsWorked: List<Any?>? = null,

		@field:SerializedName("duration")
	val duration: String? = null,

		@field:SerializedName("cover")
	val cover: Cover? = null,

		@field:SerializedName("uid")
	val uid: Int? = null,

		@field:SerializedName("iTunes")
	val iTunes: Boolean? = null,

		@field:SerializedName("typeTrackTitle")
	val typeTrackTitle: String? = null,

		@field:SerializedName("typeTrackUid")
	val typeTrackUid: Int? = null,

		@field:SerializedName("numtrack")
	val numtrack: Int? = null,

		@field:SerializedName("isgroup")
	val isgroup: Int? = null,

		@field:SerializedName("audio")
	val audio: List<AudioItem?>? = null,

		@field:SerializedName("moder")
	val moder: Int? = null,

		@field:SerializedName("pseudonym_title")
	val pseudonymTitle: String? = null,

		@field:SerializedName("isNewTrack")
	val isNewTrack: Boolean? = null,

		@field:SerializedName("album")
	val album: Album? = null,

		@field:SerializedName("uid_album")
	val uidAlbum: Int? = null,

		@field:SerializedName("style")
	val style: List<Any?>? = null,

		@field:SerializedName("uid_executor")
	val uidExecutor: Int? = null,

		@field:SerializedName("executor_moder")
	val executorModer: String? = null
)