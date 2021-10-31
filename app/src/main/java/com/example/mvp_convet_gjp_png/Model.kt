package com.example.mvp_convet_gjp_png

import android.graphics.Bitmap
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class Model {

    fun getString(): String {
        return "Hello"
    }

    fun saveImageInternalStorage(bitmaps: Bitmap) {
        val path = Environment.getExternalStorageDirectory()
        val out: OutputStream
        val file = File(path.absolutePath + "/Pictures/", "img.png")
        try {
            out = FileOutputStream(file)
            bitmaps.compress(Bitmap.CompressFormat.JPEG, 90, out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}