package dto.discogs

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Pagination(

		@field:SerializedName("per_page")
	val perPage: Int? = null,

		@field:SerializedName("urls")
	val urls: Urls? = null,

		@field:SerializedName("pages")
	val pages: Int? = null,

		@field:SerializedName("page")
	val page: Int? = null,

		@field:SerializedName("items")
	val items: Int? = null
)