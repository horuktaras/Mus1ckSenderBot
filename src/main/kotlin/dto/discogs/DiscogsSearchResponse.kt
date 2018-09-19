package dto.discogs

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DiscogsSearchResponse(

		@field:SerializedName("pagination")
	val pagination: Pagination? = null,

		@field:SerializedName("results")
	val results: List<Result?>? = null
)