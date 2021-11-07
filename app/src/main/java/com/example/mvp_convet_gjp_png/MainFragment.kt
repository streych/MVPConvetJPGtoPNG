package com.example.mvp_convet_gjp_png

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_convet_gjp_png.databinding.FragmentMainBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(), ViewSSS {

    private var _binging: FragmentMainBinding? = null
    private val binding get() = _binging!!
    private var imageUri: Uri? = null
    private val presenter: Presenter by moxyPresenter {
        Presenter(
            Model(requireContext()),
            MySchedulersFactory.create() as SchedulerClass
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binging = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = imageReturnedIntent?.data
            imageUri?.let {
                presenter.originalImage(it)
            }

        }
    }

    override fun init() {
        binding.ConvertJPGToPNG.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/jpg"
            startActivityForResult(intent, 1000)

            imageUri?.let(presenter::convertImage)
        }


    }

    override fun showOriginImage(uri: Uri) {
        binding.image.setImageURI(uri)
        imageUri?.let { presenter.convertImage(it) }
    }

}