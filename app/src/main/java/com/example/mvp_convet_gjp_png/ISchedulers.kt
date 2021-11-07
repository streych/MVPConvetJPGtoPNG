package com.example.mvp_convet_gjp_png

import io.reactivex.rxjava3.core.Scheduler

interface ISchedulers {
        fun main(): Scheduler
        fun io(): Scheduler //для операций с файловой системой. отличтска после 60 секунд простоя потока(observable.subscribeOn(Schedulers.io()))
        fun computation(): Scheduler
        fun newThread(): Scheduler
        fun single(): Scheduler
        fun trampoline(): Scheduler
        fun start()
        fun shutdown()
}
