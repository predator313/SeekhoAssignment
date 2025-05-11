package com.example.seekhoassignment.data.remote

import com.google.gson.annotations.SerializedName

data class PokeMonListResponse(
    @SerializedName("data") val data: List<PokeMonItem?>
)

data class PokeMonItem(
    @SerializedName("mal_id") val id: Int?,
    val title: String?,
    @SerializedName("episodes") val numberOfEpisode: Int?,
    @SerializedName("images") val posterImg: ImageFormats?,
    @SerializedName("score") val rating: Float?,
)

data class ImageFormats(
    val jpg: ImageUrls?,
)

data class ImageUrls(
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("small_image_url") val smallImageUrl: String?,
    @SerializedName("large_image_url") val largeImageUrl: String?
)

