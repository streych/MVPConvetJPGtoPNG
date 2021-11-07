package com.example.mvp_convet_gjp_png

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class SchedulerClass: ISchedulers {

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun io(): Scheduler = Schedulers.io()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun newThread(): Scheduler = Schedulers.newThread()

    override fun single(): Scheduler = Schedulers.single()

    override fun trampoline(): Scheduler = Schedulers.trampoline()

    override fun start() {
        Schedulers.start()
    }

    override fun shutdown() {
        Schedulers.shutdown()
    }
}

object MySchedulersFactory {
    fun create(): ISchedulers = SchedulerClass()
}
