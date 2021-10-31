package com.example.mvp_convet_gjp_png


class Presenter(var view: ViewSSS) {

    private val model = Model()

    fun btn_click(){
        view.setString(model.getString())
        //model.saveImageInternalStorage(view.getBitmao())
    }

}