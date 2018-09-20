package dto.onehundredone

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Result(

	@field:SerializedName("stat")
	val stat: Stat? = null,

	@field:SerializedName("about")
	val about: About? = null,

	@field:SerializedName("short")
	val jsonMemberShort: JsonMemberShort? = null,

	@field:SerializedName("poll")
	val poll: Boolean? = null
)