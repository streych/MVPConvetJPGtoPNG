package com.example.mvp_convet_gjp_png

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ViewSSS : MvpView {
    fun init()
    fun showOriginImage(uri: Uri)
}