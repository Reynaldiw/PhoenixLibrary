package com.reynaldiwijaya.phoenixlibrary.data.model

import com.google.gson.annotations.SerializedName

data class MovieItems(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "poster_path") val posterPath: String,
    @SerializedName(value = "overview") val overview: String

)