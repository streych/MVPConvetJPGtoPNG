package com.example.mvp_convet_gjp_png

import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import com.example.mvp_convet_gjp_png.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity() : MvpAppCompatActivity(), ViewSSS {

    private lateinit var binding: ActivityMainBinding
    private var imageUri: Uri? = null
    private val presenter: Presenter by moxyPresenter {
        Presenter(

        )
    }

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = imageReturnedIntent?.data
            imageUri?.let { presenter.originalImage(it) }

        }
    }

    override fun init() {
        binding.ConvertJPGToPNG.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/jpg"
            startActivityForResult(intent, 1000)
        }
    }

    override fun showOriginImage(uri: Uri) {
        binding.image.setImageURI(uri)
    }



}
