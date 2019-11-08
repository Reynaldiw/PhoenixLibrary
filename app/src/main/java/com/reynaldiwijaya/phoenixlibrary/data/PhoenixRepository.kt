package com.reynaldiwijaya.phoenixlibrary.data

import com.reynaldiwijaya.phoenixlibrary.data.model.MovieItems
import io.reactivex.Single

interface PhoenixRepository {
    fun getDataMovies() : Single<List<MovieItems>>
}