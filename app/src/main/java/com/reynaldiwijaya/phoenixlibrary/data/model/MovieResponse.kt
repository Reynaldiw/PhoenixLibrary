package com.reynaldiwijaya.phoenixlibrary.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponse(
    @SerializedName(value = "results") val movies: List<MovieItems>
) : Serializable