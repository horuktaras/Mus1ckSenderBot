package dto.discogs

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Result(

		@field:SerializedName("country")
	val country: String? = null,

		@field:SerializedName("resource_url")
	val resourceUrl: String? = null,

		@field:SerializedName("thumb")
	val thumb: String? = null,

		@field:SerializedName("year")
	val year: String? = null,

		@field:SerializedName("format")
	val format: List<String?>? = null,

		@field:SerializedName("label")
	val label: List<String?>? = null,

		@field:SerializedName("community")
	val community: Community? = null,

		@field:SerializedName("title")
	val title: String? = null,

		@field:SerializedName("type")
	val type: String? = null,

		@field:SerializedName("uri")
	val uri: String? = null,

		@field:SerializedName("catno")
	val catno: String? = null,

		@field:SerializedName("genre")
	val genre: List<String?>? = null,

		@field:SerializedName("style")
	val style: List<String?>? = null,

		@field:SerializedName("cover_image")
	val coverImage: String? = null,

		@field:SerializedName("id")
	val id: Int? = null,

		@field:SerializedName("barcode")
	val barcode: List<String?>? = null
)