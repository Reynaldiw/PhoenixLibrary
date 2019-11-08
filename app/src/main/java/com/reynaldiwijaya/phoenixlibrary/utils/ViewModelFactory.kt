package com.reynaldiwijaya.phoenixlibrary.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reynaldiwijaya.phoenixlibrary.data.PhoenixDataStore
import com.reynaldiwijaya.phoenixlibrary.presentation.movies.MovieViewModel
import io.reactivex.disposables.CompositeDisposable

class ViewModelFactory(
    private val disposable: CompositeDisposable,
    private val dataStore: PhoenixDataStore
) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MovieViewModel::class.java) ->
                    MovieViewModel(dataStore, disposable)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
    } as T

}