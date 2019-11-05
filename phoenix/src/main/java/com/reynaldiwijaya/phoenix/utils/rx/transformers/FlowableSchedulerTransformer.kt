package com.reynaldiwijaya.phoenix.utils.rx.transformers

import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

class FlowableSchedulerTransformer<T>(private val subscriberScheduler: Scheduler = Schedulers.io(),
                                   private val observerScheduler: Scheduler = AndroidSchedulers.mainThread()) : FlowableTransformer<T, T> {
    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
    }
}