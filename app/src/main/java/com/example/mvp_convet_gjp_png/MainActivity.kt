package com.example.mvp_convet_gjp_png

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_convet_gjp_png.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity(), ViewSSS {

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

    //BitmapFactory.decodeResource(resources, R.drawable.image_name)
    // заменить на bitmap из resultLauncher( )
    override fun getBitmao(): Bitmap = BitmapFactory.decodeResource(resources, R.drawable.image_name)

    private fun openInternalStorage() {
        val photoPickerIntent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        photoPickerIntent.type = "image/*"
        photoPickerIntent.action = Intent.ACTION_GET_CONTENT
        resultLauncher.launch(photoPickerIntent)
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            val resultCode: Int = result.resultCode
            lateinit var uri: Uri
            lateinit var bitmap: Bitmap
            if (resultCode == RESULT_OK) {
                if (data?.clipData != null) {
                    val mClipData = data.clipData
                    for (i in 0 until mClipData!!.itemCount) {
                        val item = mClipData.getItemAt(i)
                        uri = item.uri
                        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                    }

                } else if (data?.data != null) {
                    uri = data.data!!
                    // binding.image.setImageURI(uri)
                    bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                }
            }
        }

}
