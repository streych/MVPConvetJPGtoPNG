package com.example.mvp_convet_gjp_png

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_convet_gjp_png.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}