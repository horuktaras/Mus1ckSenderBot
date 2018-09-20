package dto.onehundredone

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Stat(

	@field:SerializedName("lastTime")
	val lastTime: Int? = null,

	@field:SerializedName("startSong")
	val startSong: Int? = null,

	@field:SerializedName("listenAllUsers")
	val listenAllUsers: Int? = null,

	@field:SerializedName("finishSong")
	val finishSong: Int? = null,

	@field:SerializedName("serverTime")
	val serverTime: Int? = null,

	@field:SerializedName("listenNoAuthUsers")
	val listenNoAuthUsers: Int? = null,

	@field:SerializedName("startSongTimeString")
	val startSongTimeString: String? = null,

	@field:SerializedName("listenAuthUsers")
	val listenAuthUsers: Int? = null,

	@field:SerializedName("startSongDateString")
	val startSongDateString: String? = null,

	@field:SerializedName("startSongYear")
	val startSongYear: String? = null
)