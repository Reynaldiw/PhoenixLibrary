package com.reynaldiwijaya.phoenixlibrary.data

import com.reynaldiwijaya.phoenixlibrary.data.model.MovieItems
import com.reynaldiwijaya.phoenixlibrary.data.remote.WebService
import io.reactivex.Single

class PhoenixDataStore : PhoenixRepository {
    override fun getDataMovies(): Single<List<MovieItems>> {
        return WebService.apiService.getMovies("YOUR_API_KEY")
            .map { it.movies }
    }
}