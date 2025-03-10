package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var editText1 = ""
        var editText2 = ""

        binding.btnSum.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() + editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnRzn.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() - editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnMlt.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() * editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnDvd.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() / editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}