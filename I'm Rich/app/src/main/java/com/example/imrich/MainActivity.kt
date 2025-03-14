package com.example.imrich

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.imrich.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeImage.setOnClickListener {
            binding.imgChangeView.setImageResource(R.drawable.i1)
            binding.btnChangeImage.visibility = View.INVISIBLE
        }
    }
}