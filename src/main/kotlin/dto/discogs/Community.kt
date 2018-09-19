package dto.discogs

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Community(

	@field:SerializedName("want")
	val want: Int? = null,

	@field:SerializedName("have")
	val have: Int? = null
)