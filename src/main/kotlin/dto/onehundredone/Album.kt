package dto.onehundredone

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Album(

	@field:SerializedName("uid")
	val uid: Int? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("albumTitle")
	val albumTitle: String? = null,

	@field:SerializedName("uidExecutor")
	val uidExecutor: Int? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: String? = null,

	@field:SerializedName("otherData")
	val otherData: String? = null,

	@field:SerializedName("sym")
	val sym: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("albumTypeTitle")
	val albumTypeTitle: Any? = null,

	@field:SerializedName("cover")
	val cover: Cover? = null,

	@field:SerializedName("titleExecutor")
	val titleExecutor: String? = null,

	@field:SerializedName("countTracks")
	val countTracks: Int? = null,

	@field:SerializedName("styles")
	val styles: Boolean? = null,

	@field:SerializedName("releaseDateString")
	val releaseDateString: String? = null,

	@field:SerializedName("albumTypeId")
	val albumTypeId: Int? = null
)