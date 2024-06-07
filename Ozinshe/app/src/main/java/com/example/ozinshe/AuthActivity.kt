package com.example.ozinshe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ozinshe.databinding.ActivityAuthBinding

class AuthActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val linkToReg = findViewById<TextView>(R.id.linkToReg)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        linkToReg.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }
}