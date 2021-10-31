package com.example.mvp_convet_gjp_png

import android.graphics.Bitmap
import android.os.Environment
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class Model {

    fun getString(): String {
        return "Hello"
    }

    fun saveImageInternalStorage(bitmaps: Bitmap) {

        val path = Environment.getExternalStorageDirectory()
        val file = File(path.absolutePath + "/Pictures/", "img.png")
        Observable.just(file).subscribeOn(Schedulers.newThread()).subscribe {
            val out: OutputStream
            try {
                out = FileOutputStream(file)
                bitmaps.compress(Bitmap.CompressFormat.PNG, 90, out)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}