package com.reynaldiwijaya.phoenix.utils.rx.transformers

import io.reactivex.Maybe
import io.reactivex.MaybeSource
import io.reactivex.MaybeTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MaybeSchedulerTransformer<T>(private val subscriberScheduler: Scheduler = Schedulers.io(),
                                private val observerScheduler: Scheduler = AndroidSchedulers.mainThread()) : MaybeTransformer<T, T> {
    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream.subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
    }
}