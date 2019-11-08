package com.reynaldiwijaya.phoenixlibrary.presentation.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reynaldiwijaya.phoenix.data.Result
import com.reynaldiwijaya.phoenix.utils.rx.transformers.singleScheduler
import com.reynaldiwijaya.phoenixlibrary.data.PhoenixDataStore
import com.reynaldiwijaya.phoenixlibrary.data.model.MovieItems
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MovieViewModel(
    private val dataStore: PhoenixDataStore,
    private val disposable : CompositeDisposable) : ViewModel() {

    // Use Sealed Class Result for state
    val postMovie = MutableLiveData<Result<List<MovieItems>>>()

    init {
        postMovie.value = Result.default()
    }

    fun getMovie() {
        postMovie.value = Result.loading()
        dataStore.getDataMovies()
                // Use SingleScheduler or etc for observeOn and AndroidSchedulers
            .compose(singleScheduler())
            .subscribe({
                if (it.isNullOrEmpty()) {
                    postMovie.value = Result.empty()
                } else {
                    postMovie.value = Result.success(it)
                }
            }, {
                postMovie.value = Result.fail(it.message)
            })
            .addTo(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

}