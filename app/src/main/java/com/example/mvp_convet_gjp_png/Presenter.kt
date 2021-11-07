package com.example.mvp_convet_gjp_png

import android.net.Uri
import android.util.Log
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter



class Presenter(private val model: Model, private val schedulers: SchedulerClass) : MvpPresenter<ViewSSS>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun originalImage(imgUri: Uri){
        viewState.showOriginImage(imgUri)
    }


    fun convertImage(imgUri: Uri) {
        model
            .saveImageInternalStorage(imgUri)
            .subscribeOn(schedulers.computation())
            .observeOn(schedulers.main())
            .subscribe(object : SingleObserver<Uri> {
                override fun onSubscribe(d: Disposable) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(t: Uri) {
                    Log.i("Good", "Good")
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

            })


    }


}