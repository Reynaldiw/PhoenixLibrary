package com.reynaldiwijaya.phoenix.utils.rx.transformers

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CompletableSchedulerTransformer(private val subscriberScheduler: Scheduler = Schedulers.io(),
                                         private val observerScheduler: Scheduler = AndroidSchedulers.mainThread()) : CompletableTransformer{
    override fun apply(upstream: Completable): CompletableSource {
        return upstream.subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
    }

}