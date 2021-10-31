package com.example.mvp_convet_gjp_png

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_convet_gjp_png.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class MainActivity : AppCompatActivity(), ViewSSS {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter(this)

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = View.OnClickListener {
            presenter.btn_click()
            openInternalStorage()
        }
        binding.ConvertJPGToPNG.setOnClickListener(listener)
    }


    override fun setString(string: String) {
        binding.CCCC.text = string
    }

    private fun openInternalStorage() {
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        resultLauncher.launch(photoPickerIntent)
    }


    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            val resultCode: Int = result.resultCode
            var bitmap: Bitmap
            if (resultCode == RESULT_OK) {
                if (data?.clipData != null) {
                    val mClipData = data.clipData
                    for (i in 0 until mClipData!!.itemCount) {
                        val item = mClipData.getItemAt(i)
                        val uri = item.uri
                        // display your images
                        binding.image.setImageURI(uri)
                        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)

                    }
                } else if (data?.data != null) {
                    val uri = data.data
                    // display your image
                    binding.image.setImageURI(uri)
                    bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)

                }
            }
        }

    private fun saveImageInternalStorage(bitmaps: Bitmap) {
        val path = Environment.getExternalStorageDirectory()
        val out: OutputStream
        val file = File(path.absolutePath + "/Pictures/", "img.png")
        try {
            out = FileOutputStream(file)
            bitmaps.compress(Bitmap.CompressFormat.JPEG, 90, out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //binding.image.setImageBitmap(bitmaps)
    }

}
