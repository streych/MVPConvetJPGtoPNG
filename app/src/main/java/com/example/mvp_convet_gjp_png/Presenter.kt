package com.example.mvp_convet_gjp_png

import android.net.Uri
import moxy.MvpPresenter


class Presenter() : MvpPresenter<ViewSSS>() {



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun originalImage(imgUri: Uri){
        viewState.showOriginImage(imgUri)
    }
}