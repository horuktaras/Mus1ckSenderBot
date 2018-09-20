package dto.onehundredone

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AudioItem(

	@field:SerializedName("uid")
	val uid: Int? = null,

	@field:SerializedName("statusReady")
	val statusReady: Int? = null,

	@field:SerializedName("typedata")
	val typedata: String? = null,

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("uidTrack")
	val uidTrack: Int? = null,

	@field:SerializedName("full_sample_track")
	val fullSampleTrack: String? = null,

	@field:SerializedName("time")
	val time: Int? = null,

	@field:SerializedName("sample")
	val sample: String? = null,

	@field:SerializedName("trackuid")
	val trackuid: Int? = null
)