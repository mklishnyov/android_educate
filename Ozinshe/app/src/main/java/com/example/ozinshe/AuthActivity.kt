package com.example.ozinshe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.ozinshe.databinding.ActivityAuthBinding

class AuthActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageButton = findViewById(R.id.btn_back)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}