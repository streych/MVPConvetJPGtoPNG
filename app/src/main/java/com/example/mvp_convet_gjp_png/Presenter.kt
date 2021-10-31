package com.example.mvp_convet_gjp_png


class Presenter(var view: ViewSSS) {

    private val model = Model()

    fun btn_click(){
        model.saveImageInternalStorage(view.getBitmao())
}

}