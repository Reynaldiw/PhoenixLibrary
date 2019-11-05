package com.reynaldiwijaya.phoenix.utils.rx.transformers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> observableScheduler(subsriberScheduler : Scheduler = Schedulers.io(), observerScheduler : Scheduler = AndroidSchedulers.mainThread()) : ObservableSchedulerTransformer<T> {
    return ObservableSchedulerTransformer(subsriberScheduler, observerScheduler)
}

fun <T> singleScheduler(subscriberScheduler: Scheduler = Schedulers.io(), observerScheduler: Scheduler = AndroidSchedulers.mainThread()): SingleSchedulerTransformer<T> {
    return SingleSchedulerTransformer(subscriberScheduler, observerScheduler)
}

fun <T> flowableScheduler(subscriberScheduler: Scheduler = Schedulers.io(), observerScheduler: Scheduler = AndroidSchedulers.mainThread()): FlowableSchedulerTransformer<T> {
    return FlowableSchedulerTransformer(subscriberScheduler, observerScheduler)
}

fun <T> maybeScheduler(subscriberScheduler: Scheduler = Schedulers.io(), observerScheduler: Scheduler = AndroidSchedulers.mainThread()): MaybeSchedulerTransformer<T> {
    return MaybeSchedulerTransformer(subscriberScheduler, observerScheduler)
}

fun <T> completableScheduler(subscriberScheduler: Scheduler = Schedulers.io(), observerScheduler: Scheduler = AndroidSchedulers.mainThread()): CompletableSchedulerTransformer {
    return CompletableSchedulerTransformer(subscriberScheduler, observerScheduler)
}