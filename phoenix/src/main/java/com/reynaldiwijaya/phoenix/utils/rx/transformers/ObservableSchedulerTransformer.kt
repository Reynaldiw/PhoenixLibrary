package com.reynaldiwijaya.phoenix.utils.rx.transformers

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ObservableSchedulerTransformer<T>(private val subscriberScheduler : Scheduler = Schedulers.io(),
                                        private val observerScheduler : Scheduler = AndroidSchedulers.mainThread()) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
    }
}